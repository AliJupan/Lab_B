package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.create.CreateCountryDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto);
    Optional<DisplayCountryDto> update(Long id,CreateCountryDto createCountryDto);
    void delete(Long id);

    void refreshMaterializedView();

}
