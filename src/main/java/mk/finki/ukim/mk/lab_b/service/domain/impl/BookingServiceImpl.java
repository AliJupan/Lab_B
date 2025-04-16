package mk.finki.ukim.mk.lab_b.service.domain.impl;


import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.model.domain.Booking;
import mk.finki.ukim.mk.lab_b.model.domain.User;
import mk.finki.ukim.mk.lab_b.model.exceptions.AccommodationAlreadyInBookingException;
import mk.finki.ukim.mk.lab_b.model.exceptions.AccommodationNotFoundException;
import mk.finki.ukim.mk.lab_b.model.exceptions.BookingNotFoundException;
import mk.finki.ukim.mk.lab_b.repository.BookingRepository;
import mk.finki.ukim.mk.lab_b.service.domain.AccommodationService;
import mk.finki.ukim.mk.lab_b.service.domain.BookingService;
import mk.finki.ukim.mk.lab_b.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    UserService userService;
    AccommodationService accommodationService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, AccommodationService accommodationService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Accommodation> listAllAccommodationsInBooking(Long bookingId) {
        if (bookingRepository.findById(bookingId).isEmpty())
            throw new BookingNotFoundException(bookingId);
        return bookingRepository.findById(bookingId).get().getAccommodations();
    }

    @Override
    public Optional<Booking> getActiveBooking(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(bookingRepository.findByUser(user)
                .orElseGet(() -> bookingRepository.save(new Booking(user))));
    }

    @Override
    public Optional<Booking> addAccommodationToBooking(String username, Long accommodationId) {
        if (getActiveBooking(username).isPresent()) {
            Booking booking = getActiveBooking(username).get();

            Accommodation accommodation = accommodationService.findById(accommodationId)
                    .orElseThrow(() -> new AccommodationNotFoundException(accommodationId));
            if (!booking.getAccommodations().stream().filter(i -> i.getId().equals(accommodationId)).toList().isEmpty())
                throw new AccommodationAlreadyInBookingException(accommodationId, username);
            booking.getAccommodations().add(accommodation);
            return Optional.of(bookingRepository.save(booking));
        }
        return Optional.empty();
    }
}
