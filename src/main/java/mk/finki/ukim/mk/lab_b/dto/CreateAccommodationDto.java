package mk.finki.ukim.mk.lab_b.dto;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.enumerations.Category;

public record CreateAccommodationDto(String name, Category category, Host host, int numRooms, boolean active) {

    public Accommodation toAccommodation() {
        return new Accommodation(name, category, host, numRooms, active);
    }

}
