package mk.finki.ukim.mk.lab_b.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.finki.ukim.mk.lab_b.dto.CreateHostDto;
import mk.finki.ukim.mk.lab_b.dto.DisplayHostDto;
import mk.finki.ukim.mk.lab_b.service.application.impl.HostApplicationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostApplicationServiceImpl hostService;

    public HostController(HostApplicationServiceImpl hostService) {
        this.hostService = hostService;
    }

    @Operation(summary = "Get all hosts", description = "Returns a list of all hosts.")
    @GetMapping
    public List<DisplayHostDto> findAll() {
        return hostService.findAll();
    }

    @Operation(summary = "Get host by ID", description = "Returns a specific host by their ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new host", description = "Creates and returns a new host based on the provided data.")
    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto createHostDto) {
        return hostService.save(createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update existing host", description = "Updates a host with the specified ID using the provided data.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto createHostDto) {
        return hostService.update(id, createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete host by ID", description = "Deletes the host with the specified ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (hostService.findById(id).isPresent()) {
            hostService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
