package mk.finki.ukim.mk.lab_b.service;

import mk.finki.ukim.mk.lab_b.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(int id);
    Country save(Country country);
    Country update(int id,Country country);
    void delete(int id);
}
