package mk.finki.ukim.mk.lab_b.web;

import mk.finki.ukim.mk.lab_b.model.Host;
import mk.finki.ukim.mk.lab_b.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public List<Host> findAll() {
        return hostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable int id) {
        Host host = hostService.findById(id);
        return host != null ? ResponseEntity.ok().body(host) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Host> save(@RequestBody Host host) {
        Host savedHost = hostService.save(host);
        return savedHost != null ? ResponseEntity.ok().body(savedHost) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Host> update(@PathVariable int id, @RequestBody Host host) {
        Host updatedHost = hostService.update(id, host);
        return updatedHost != null ? ResponseEntity.ok().body(updatedHost) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Host host = hostService.findById(id);
        if (host != null) {
            hostService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
