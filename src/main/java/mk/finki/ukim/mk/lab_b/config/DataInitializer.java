package mk.finki.ukim.mk.lab_b.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab_b.model.Accommodation;
import mk.finki.ukim.mk.lab_b.model.Category;
import mk.finki.ukim.mk.lab_b.model.Country;
import mk.finki.ukim.mk.lab_b.model.Host;
import mk.finki.ukim.mk.lab_b.repository.AccommodationRepository;
import mk.finki.ukim.mk.lab_b.repository.CountryRepository;
import mk.finki.ukim.mk.lab_b.repository.HostRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {
        // Initialize Countries
        Country usa = countryRepository.save(new Country("USA", "North America"));
        Country uk = countryRepository.save(new Country( "UK", "Europe"));
        Country france = countryRepository.save(new Country( "France", "Europe"));

        // Initialize Hosts
        Host johnDoe = hostRepository.save(new Host( "John", "Doe", usa));
        Host janeSmith = hostRepository.save(new Host( "Jane", "Smith", uk));
        Host pierreDupont = hostRepository.save(new Host( "Pierre", "Dupont", france));

        // Initialize Accommodations
        accommodationRepository.save(new Accommodation("Hotel USA", Category.HOTEL, johnDoe, 50,true));
        accommodationRepository.save(new Accommodation("Apartment UK", Category.APARTMENT, janeSmith, 3,false));
        accommodationRepository.save(new Accommodation("Hostel Paris", Category.MOTEL, pierreDupont, 20,true));
    }
}