package mk.finki.ukim.mk.lab_b.service.domain;

import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.projections.HostNameProjection;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> save(Host host);
    void delete(Long id);
    Optional<Host> update(Long id,Host host);

    List<HostNameProjection> findHostNames();
}
