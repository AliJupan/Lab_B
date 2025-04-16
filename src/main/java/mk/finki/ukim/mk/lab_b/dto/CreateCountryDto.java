package mk.finki.ukim.mk.lab_b.dto;

import mk.finki.ukim.mk.lab_b.model.domain.Country;

public record CreateCountryDto(String name, String continent) {

    public Country toCountry() {
        return new Country(name, continent);
    }
}
