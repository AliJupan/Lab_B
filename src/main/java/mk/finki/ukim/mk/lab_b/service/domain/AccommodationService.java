package mk.finki.ukim.mk.lab_b.service.domain;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> save(Accommodation accommodation);
    void deleteById(Long id);
    Optional<Accommodation> update(Long id, Accommodation accommodation);
    Optional<Accommodation> setActive(Long id);
}
