package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.create.CreateHostDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayHostDto;
import mk.finki.ukim.mk.lab_b.model.projections.HostNameProjection;
import mk.finki.ukim.mk.lab_b.model.views.AccommodationsPerHostView;
import mk.finki.ukim.mk.lab_b.model.views.HostsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> findById(Long id);
    Optional<DisplayHostDto> save(CreateHostDto createHostDto);
    void delete(Long id);
    Optional<DisplayHostDto> update(Long id,CreateHostDto createHostDto);

    List<HostNameProjection> findHostNames();

    List<HostsPerCountryView> getHostPerCountry();
    void refreshMaterializedView();
}
