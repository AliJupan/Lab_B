package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.CreateHostDto;
import mk.finki.ukim.mk.lab_b.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> findById(Long id);
    Optional<DisplayHostDto> save(CreateHostDto createHostDto);
    void delete(Long id);
    Optional<DisplayHostDto> update(Long id,CreateHostDto createHostDto);
}
