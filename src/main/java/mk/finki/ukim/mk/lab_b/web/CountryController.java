package mk.finki.ukim.mk.lab_b.web;

import mk.finki.ukim.mk.lab_b.model.Country;
import mk.finki.ukim.mk.lab_b.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable int id) {
        Country country = countryService.findById(id);
        return country != null ? ResponseEntity.ok().body(country) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return savedCountry != null ? ResponseEntity.ok().body(savedCountry) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable int id, @RequestBody Country country) {
        Country updatedCountry = countryService.update(id, country);
        return updatedCountry != null ? ResponseEntity.ok().body(updatedCountry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Country country = countryService.findById(id);
        if (country != null) {
            countryService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}