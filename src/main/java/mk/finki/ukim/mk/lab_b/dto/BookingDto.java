package mk.finki.ukim.mk.lab_b.dto;

import mk.finki.ukim.mk.lab_b.model.domain.Booking;

import java.time.LocalDateTime;
import java.util.List;

public record BookingDto(Long Id, LocalDateTime createdAt, DisplayUserDto user, List<DisplayAccommodationDto> accommodation) {

    public static BookingDto from(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getCreatedAt(),
                DisplayUserDto.from(booking.getUser()),
                DisplayAccommodationDto.from(booking.getAccommodations()));
    }
}
