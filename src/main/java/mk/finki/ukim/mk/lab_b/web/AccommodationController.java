package mk.finki.ukim.mk.lab_b.web;

import mk.finki.ukim.mk.lab_b.model.Accommodation;
import mk.finki.ukim.mk.lab_b.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable int id) {
        Accommodation accommodation = accommodationService.findById(id);
        return accommodation != null ? ResponseEntity.ok().body(accommodation) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody Accommodation accommodation) {
        Accommodation savedAccommodation = accommodationService.save(accommodation);
        return savedAccommodation != null ? ResponseEntity.ok().body(savedAccommodation) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable int id, @RequestBody Accommodation accommodation) {
        Accommodation updatedAccommodation = accommodationService.update(id, accommodation);
        return updatedAccommodation != null ? ResponseEntity.ok().body(updatedAccommodation) : ResponseEntity.notFound().build();
    }

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

    @PutMapping("/active/{id}")
    public ResponseEntity<Accommodation> active(@PathVariable int id) {
        Accommodation updatedAccommodation = accommodationService.setActive(id);
        return updatedAccommodation != null ? ResponseEntity.ok().body(updatedAccommodation) : ResponseEntity.notFound().build();
    }
}