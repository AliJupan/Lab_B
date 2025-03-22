package mk.finki.ukim.mk.lab_b.service;

import mk.finki.ukim.mk.lab_b.model.Country;
import mk.finki.ukim.mk.lab_b.model.Host;

import java.util.List;

public interface HostService {
    List<Host> findAll();
    Host findById(int id);
    Host save(Host host);
    void delete(int id);
    Host update(int id,Host host);
}
