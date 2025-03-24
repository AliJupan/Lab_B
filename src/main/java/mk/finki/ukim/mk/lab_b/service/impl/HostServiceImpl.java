package mk.finki.ukim.mk.lab_b.service.impl;

import mk.finki.ukim.mk.lab_b.model.Host;
import mk.finki.ukim.mk.lab_b.repository.HostRepository;
import mk.finki.ukim.mk.lab_b.service.CountryService;
import mk.finki.ukim.mk.lab_b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Host findById(int id) {
        return this.hostRepository.findById(Long.parseLong(String.valueOf(id))).orElse(null);
    }

    @Override
    public Host save(Host host) {
        return this.hostRepository.save(host);
    }

    @Override
    public void delete(int id) {
        Host host = this.findById(id);
        this.hostRepository.delete(host);
    }

    @Override
    public Host update(int id, Host host) {
        Host existingHost = this.findById(id);
        existingHost.setName(host.getName());
        existingHost.setSurname(host.getSurname());
        existingHost.setCountry(host.getCountry());

        this.hostRepository.save(host);

        return host;
    }
}
