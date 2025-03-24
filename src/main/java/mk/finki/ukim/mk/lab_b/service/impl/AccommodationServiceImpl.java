package mk.finki.ukim.mk.lab_b.service.impl;

import mk.finki.ukim.mk.lab_b.model.Accommodation;
import mk.finki.ukim.mk.lab_b.repository.AccommodationRepository;
import mk.finki.ukim.mk.lab_b.service.AccommodationService;
import mk.finki.ukim.mk.lab_b.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    AccommodationRepository accommodationRepository;
    HostService hostService;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Accommodation findById(int id) {
        return this.accommodationRepository.findById(Long.parseLong(String.valueOf(id))).orElse(null);
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteById(int id) {
        Accommodation accommodation = this.findById(id);
        accommodationRepository.delete(accommodation);
    }

    @Override
    public Accommodation update(int id, Accommodation accommodation) {

        Accommodation existingAccommodation = this.findById(id);
        existingAccommodation.setName(accommodation.getName());
        existingAccommodation.setCategory(accommodation.getCategory());
        existingAccommodation.setHost(accommodation.getHost());
        existingAccommodation.setNumRooms(accommodation.getNumRooms());

        accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public Accommodation setActive(int id) {
        Accommodation existingAccommodation = this.findById(id);
        existingAccommodation.setActive(!existingAccommodation.isActive());
        return accommodationRepository.save(existingAccommodation);
    }
}
