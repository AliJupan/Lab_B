//package mk.finki.ukim.mk.lab_b.config;
//
//import jakarta.annotation.PostConstruct;
//import mk.finki.ukim.mk.lab_b.model.domain.*;
//import mk.finki.ukim.mk.lab_b.model.enumerations.Role;
//import mk.finki.ukim.mk.lab_b.model.enumerations.Category;
//import mk.finki.ukim.mk.lab_b.repository.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer {
//
//    private final CountryRepository countryRepository;
//    private final HostRepository hostRepository;
//    private final AccommodationRepository accommodationRepository;
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final BookingRepository bookingRepository;
//
//
//    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, BookingRepository bookingRepository) {
//        this.countryRepository = countryRepository;
//        this.hostRepository = hostRepository;
//        this.accommodationRepository = accommodationRepository;
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.bookingRepository = bookingRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//         //Initialize Countries
//        Country usa = countryRepository.save(new Country("USA", "North America"));
//        Country uk = countryRepository.save(new Country( "UK", "Europe"));
//        Country france = countryRepository.save(new Country( "France", "Europe"));
//
//         //Initialize Hosts
//        Host johnDoe = hostRepository.save(new Host( "John", "Doe", usa));
//        Host janeSmith = hostRepository.save(new Host( "Jane", "Smith", uk));
//        Host pierreDupont = hostRepository.save(new Host( "Pierre", "Dupont", france));
//
//         //Initialize Accommodations
//        accommodationRepository.save(new Accommodation("Hotel USA", Category.HOTEL, johnDoe, 50,true));
//        accommodationRepository.save(new Accommodation("Apartment UK", Category.APARTMENT, janeSmith, 3,false));
//        accommodationRepository.save(new Accommodation("Hostel Paris", Category.MOTEL, pierreDupont, 20,true));
//
//        userRepository.save(new User(
//                "admin",
//                passwordEncoder.encode("admin"),
//                "test",
//                "test",
//                Role.ROLE_HOST
//        ));
//
//        userRepository.save(new User(
//                "user",
//                passwordEncoder.encode("user"),
//                "user",
//                "user",
//                Role.ROLE_USER
//        ));
//
//        User user = new User("testUser", passwordEncoder.encode("test"), "John", "Doe", Role.ROLE_USER);
//        userRepository.save(user);
//
//        Booking booking = new Booking(user);
//        bookingRepository.save(booking);
//
//    }
//}