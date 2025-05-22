package mk.finki.ukim.mk.lab_b.service.application.impl;

import mk.finki.ukim.mk.lab_b.dto.create.CreateHostDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayAccommodationDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayHostDto;
import mk.finki.ukim.mk.lab_b.events.HostChangedEvent;
import mk.finki.ukim.mk.lab_b.events.HostDeletedEvent;
import mk.finki.ukim.mk.lab_b.model.domain.Country;
import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.projections.HostNameProjection;
import mk.finki.ukim.mk.lab_b.model.views.HostsPerCountryView;
import mk.finki.ukim.mk.lab_b.repository.HostsPerCountryViewRepository;
import mk.finki.ukim.mk.lab_b.service.application.HostApplicationService;
import mk.finki.ukim.mk.lab_b.service.domain.CountryService;
import mk.finki.ukim.mk.lab_b.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    HostService hostService;
    HostsPerCountryViewRepository hostsPerCountryViewRepository;
    CountryService countryService;
    ApplicationEventPublisher applicationEvent;

    public HostApplicationServiceImpl(HostService hostService, HostsPerCountryViewRepository hostsPerCountryViewRepository, ApplicationEventPublisher applicationEvent, CountryService countryService) {
        this.hostService = hostService;
        this.hostsPerCountryViewRepository = hostsPerCountryViewRepository;
        this.applicationEvent = applicationEvent;
        this.countryService = countryService;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.countryId());

        if (country.isPresent()) {
            return hostService.save(createHostDto.toHost(country.get()))
                    .map(DisplayHostDto::from);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        hostService.findById(id).ifPresent(host ->
                applicationEvent.publishEvent(new HostDeletedEvent(host))
        );
        hostService.delete(id);
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.countryId());

        return hostService.update(id,
                        createHostDto.toHost(
                                country.orElse(null)
                        )
                )
                .map(DisplayHostDto::from);
    }

    @Override
    public List<HostNameProjection> findHostNames() {
        return hostService.findHostNames();
    }


    @Override
    public List<HostsPerCountryView> getHostPerCountry() {
        return this.hostsPerCountryViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        this.hostsPerCountryViewRepository.refreshMaterializedViews();
    }
}
