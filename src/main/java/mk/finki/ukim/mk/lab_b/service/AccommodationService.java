package mk.finki.ukim.mk.lab_b.service;

import mk.finki.ukim.mk.lab_b.model.Accommodation;
import mk.finki.ukim.mk.lab_b.model.Category;
import mk.finki.ukim.mk.lab_b.model.Host;

import java.util.List;

public interface AccommodationService {
    List<Accommodation> findAll();
    Accommodation findById(int id);
    Accommodation save(Accommodation accommodation);
    void deleteById(int id);
    Accommodation update(int id, Accommodation accommodation);
}
