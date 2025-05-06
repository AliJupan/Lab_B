package mk.finki.ukim.mk.lab_b.service.domain.impl;

import mk.finki.ukim.mk.lab_b.model.domain.Host;
import mk.finki.ukim.mk.lab_b.model.projections.HostNameProjection;
import mk.finki.ukim.mk.lab_b.repository.HostRepository;
import mk.finki.ukim.mk.lab_b.service.domain.CountryService;
import mk.finki.ukim.mk.lab_b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    HostRepository hostRepository;
    CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.of(this.hostRepository.save(host));
    }

    @Override
    public void delete(Long id) {
        this.hostRepository.deleteById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingHost -> {
            if (host.getName() != null) {
                existingHost.setName(host.getName());
            }
            if (host.getSurname() != null) {
                existingHost.setSurname(host.getSurname());
            }
            if (host.getCountry() != null) {
                existingHost.setCountry(host.getCountry());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public List<HostNameProjection> findHostNames() {
        return hostRepository.findAllBy();
    }
}
