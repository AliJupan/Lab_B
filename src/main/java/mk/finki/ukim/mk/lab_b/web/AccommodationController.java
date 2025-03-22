package mk.finki.ukim.mk.lab_b.web;

import mk.finki.ukim.mk.lab_b.model.Accommodation;
import mk.finki.ukim.mk.lab_b.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations") // Consistent with /api/countries and /api/hosts
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    // READ (Get all accommodations)
    @GetMapping
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }

    // READ (Get accommodation by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable int id) {
        Accommodation accommodation = accommodationService.findById(id);
        return accommodation != null ? ResponseEntity.ok().body(accommodation) : ResponseEntity.notFound().build();
    }

    // CREATE (Add a new accommodation)
    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody Accommodation accommodation) {
        Accommodation savedAccommodation = accommodationService.save(accommodation);
        return savedAccommodation != null ? ResponseEntity.ok().body(savedAccommodation) : ResponseEntity.badRequest().build();
    }

    // UPDATE (Edit an existing accommodation)
    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable int id, @RequestBody Accommodation accommodation) {
        Accommodation updatedAccommodation = accommodationService.update(id, accommodation);
        return updatedAccommodation != null ? ResponseEntity.ok().body(updatedAccommodation) : ResponseEntity.notFound().build();
    }

    // DELETE (Remove an accommodation)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Accommodation accommodation = accommodationService.findById(id);
        if (accommodation != null) {
            accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}