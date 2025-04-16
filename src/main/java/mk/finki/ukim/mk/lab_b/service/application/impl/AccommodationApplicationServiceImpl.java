package mk.finki.ukim.mk.lab_b.service.application.impl;

import mk.finki.ukim.mk.lab_b.dto.CreateAccommodationDto;
import mk.finki.ukim.mk.lab_b.dto.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.service.application.AccommodationApplicationService;
import mk.finki.ukim.mk.lab_b.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    AccommodationService accommodationService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {
        return accommodationService.save(createAccommodationDto.toAccommodation()).map(DisplayAccommodationDto::from);
    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        return accommodationService.save(createAccommodationDto.toAccommodation()).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> setActive(Long id) {
        return accommodationService.setActive(id).map(DisplayAccommodationDto::from);
    }
}
