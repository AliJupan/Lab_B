package mk.finki.ukim.mk.lab_b.service.impl;

import mk.finki.ukim.mk.lab_b.model.Country;
import mk.finki.ukim.mk.lab_b.repository.CountryRepository;
import mk.finki.ukim.mk.lab_b.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return this.countryRepository.findById(Long.parseLong(String.valueOf(id))).orElse(null);
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Country update(int id, Country country) {
        Country existingCountry = this.findById(id);
        existingCountry.setName(country.getName());
        existingCountry.setContinent(country.getContinent());

        this.countryRepository.save(country);
        return country;
    }

    @Override
    public void delete(int id) {
        Country country = this.findById(id);
        this.countryRepository.delete(country);
    }
}
