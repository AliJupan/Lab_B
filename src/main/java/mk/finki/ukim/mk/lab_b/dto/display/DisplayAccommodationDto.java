package mk.finki.ukim.mk.lab_b.dto.display;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(Long id,String name, Category category, Long host, int numRooms, boolean active) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        Long hostId = accommodation.getHost() != null ? accommodation.getHost().getId() : null;

        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                hostId,
                accommodation.getNumRooms(),
                accommodation.isActive()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }
}
