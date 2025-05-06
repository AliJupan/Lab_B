package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.create.CreateAccommodationDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.model.views.AccommodationsPerHostView;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto> findById(Long id);
    Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto);
    void deleteById(Long id);
    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);
    Optional<DisplayAccommodationDto>  setActive(Long id);

    List<AccommodationsPerHostView> getAccommodationsPerHost();
    void refreshMaterializedView();
}
