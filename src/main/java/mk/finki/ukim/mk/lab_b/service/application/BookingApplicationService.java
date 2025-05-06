package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.display.BookingDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface BookingApplicationService {

    List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId);

    Optional<BookingDto> getActiveBooking(String username);

    Optional<BookingDto> addAccommodationToBooking(String username, Long accommodationId);
}
