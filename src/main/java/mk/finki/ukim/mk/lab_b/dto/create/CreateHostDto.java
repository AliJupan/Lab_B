package mk.finki.ukim.mk.lab_b.dto.create;

import mk.finki.ukim.mk.lab_b.model.domain.Country;
import mk.finki.ukim.mk.lab_b.model.domain.Host;

public record CreateHostDto(String name, String surname, Country country) {

    public Host toHost() {
        return new Host(name, surname, country);
    }
}
