package mk.finki.ukim.mk.lab_b.repository;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
