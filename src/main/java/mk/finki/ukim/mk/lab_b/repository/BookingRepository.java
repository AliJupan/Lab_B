package mk.finki.ukim.mk.lab_b.repository;

import mk.finki.ukim.mk.lab_b.model.domain.Booking;
import mk.finki.ukim.mk.lab_b.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByUser(User user);
}
