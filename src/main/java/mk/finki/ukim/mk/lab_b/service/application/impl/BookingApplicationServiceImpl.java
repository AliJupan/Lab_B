package mk.finki.ukim.mk.lab_b.service.application.impl;

import mk.finki.ukim.mk.lab_b.dto.display.BookingDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.service.application.BookingApplicationService;
import mk.finki.ukim.mk.lab_b.service.domain.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingApplicationServiceImpl implements BookingApplicationService {

    BookingService bookingService;

    public BookingApplicationServiceImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId) {
        return DisplayAccommodationDto.from(bookingService.listAllAccommodationsInBooking(bookingId));
    }

    @Override
    public Optional<BookingDto> getActiveBooking(String username) {
        return bookingService.getActiveBooking(username).map(BookingDto::from);
    }

    @Override
    public Optional<BookingDto> addAccommodationToBooking(String username, Long accommodationId) {
        return bookingService.addAccommodationToBooking(username, accommodationId).map(BookingDto::from);
    }
}
