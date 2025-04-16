package mk.finki.ukim.mk.lab_b.service.domain;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.model.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Accommodation> listAllAccommodationsInBooking(Long bookingId);

    Optional<Booking> getActiveBooking(String username);

    Optional<Booking> addAccommodationToBooking(String username, Long accommodationId);
}
