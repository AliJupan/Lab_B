package mk.finki.ukim.mk.lab_b.dto.create;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAccommodationDto(String name, Category category, Long hostId, int numRooms, boolean active) {


    public static CreateAccommodationDto from(Accommodation accommodation) {
        return new CreateAccommodationDto(
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getNumRooms(),
                accommodation.isActive()
        );
    }

    public static List<CreateAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(CreateAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, numRooms, active);
    }

}
