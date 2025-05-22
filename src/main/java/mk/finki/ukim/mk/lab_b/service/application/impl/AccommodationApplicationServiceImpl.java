package mk.finki.ukim.mk.lab_b.service.application.impl;

import mk.finki.ukim.mk.lab_b.dto.create.CreateAccommodationDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.views.AccommodationsPerHostView;
import mk.finki.ukim.mk.lab_b.repository.AccommodationsPerHostViewRepository;
import mk.finki.ukim.mk.lab_b.service.application.AccommodationApplicationService;
import mk.finki.ukim.mk.lab_b.service.domain.AccommodationService;
import mk.finki.ukim.mk.lab_b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    AccommodationService accommodationService;
    AccommodationsPerHostViewRepository accommodationsPerHostViewRepository;
    HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, AccommodationsPerHostViewRepository accommodationsPerHostViewRepository, HostService hostService) {
        this.accommodationService = accommodationService;
        this.accommodationsPerHostViewRepository = accommodationsPerHostViewRepository;
        this.hostService = hostService;
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
        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());

        if (host.isPresent()) {
            return accommodationService.save(createAccommodationDto.toAccommodation(host.get()))
                    .map(DisplayAccommodationDto::from);
        }
        return Optional.empty();

    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());

        return accommodationService.update(id,
                        createAccommodationDto.toAccommodation(
                                host.orElse(null)
                        )
                )
                .map(DisplayAccommodationDto::from);

    }

    @Override
    public Optional<DisplayAccommodationDto> setActive(Long id) {
        return accommodationService.setActive(id).map(DisplayAccommodationDto::from);
    }


    //views

    @Override
    public List<AccommodationsPerHostView> getAccommodationsPerHost() {
        return this.accommodationsPerHostViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        accommodationsPerHostViewRepository.refreshMaterializedViews();
    }
}
