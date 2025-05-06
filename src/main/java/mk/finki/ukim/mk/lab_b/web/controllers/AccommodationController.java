package mk.finki.ukim.mk.lab_b.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import mk.finki.ukim.mk.lab_b.dto.create.CreateAccommodationDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.service.application.AccommodationApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationApplicationService accommodationService;

    public AccommodationController(AccommodationApplicationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Operation(summary = "Get all accommodations", description = "Returns a list of all accommodations.")
    @GetMapping
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll();
    }

    @Operation(summary = "Get accommodation by ID", description = "Returns a specific accommodation by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new accommodation", description = "Creates and returns a new accommodation based on the provided data.")
    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> save(@RequestBody CreateAccommodationDto createAccommodationDto) {
        return accommodationService.save(createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update accommodation", description = "Updates an existing accommodation with the given ID.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayAccommodationDto> update(@PathVariable Long id, @RequestBody CreateAccommodationDto createAccommodationDto) {
        return accommodationService.update(id, createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete accommodation by ID", description = "Deletes the accommodation with the specified ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (accommodationService.findById(id).isPresent()) {
            accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Activate accommodation", description = "Marks an accommodation as active by its ID.")
    @PutMapping("/active/{id}")
    public ResponseEntity<DisplayAccommodationDto> active(@PathVariable Long id) {
        return accommodationService.setActive(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // views

    @GetMapping("/by-host")
    @Operation(summary = "")
    public ResponseEntity<?> getAccommodationsPerHost() {
        return ResponseEntity.status(HttpStatus.OK).body(accommodationService.getAccommodationsPerHost());
    }
}