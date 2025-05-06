package mk.finki.ukim.mk.lab_b.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab_b.repository.AccommodationsPerHostViewRepository;
import mk.finki.ukim.mk.lab_b.repository.HostsPerCountryViewRepository;
import org.springframework.stereotype.Component;

@Component
public class MaterializedViewRefresher {

    private final AccommodationsPerHostViewRepository accommodationsPerHostViewRepository;
    private final HostsPerCountryViewRepository hostsPerCountryViewRepository;


    public MaterializedViewRefresher(AccommodationsPerHostViewRepository accommodationsPerHostViewRepository, HostsPerCountryViewRepository hostsPerCountryViewRepository) {
        this.accommodationsPerHostViewRepository = accommodationsPerHostViewRepository;
        this.hostsPerCountryViewRepository = hostsPerCountryViewRepository;
    }

    @PostConstruct
    void init(){
        accommodationsPerHostViewRepository.refreshMaterializedViews();
        hostsPerCountryViewRepository.refreshMaterializedViews();
    }
}
