package mk.finki.ukim.mk.lab_b.service.domain.impl;

import mk.finki.ukim.mk.lab_b.model.domain.Accommodation;
import mk.finki.ukim.mk.lab_b.repository.AccommodationRepository;
import mk.finki.ukim.mk.lab_b.service.domain.AccommodationService;
import mk.finki.ukim.mk.lab_b.service.domain.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Accommodation> findById(Long id) {
        return this.accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(Accommodation accommodation) {
        return Optional.of(this.accommodationRepository.save(accommodation));
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            if (accommodation.getName() != null) {
                existingAccommodation.setName(accommodation.getName());
            }
            if (accommodation.getCategory() != null) {
                existingAccommodation.setCategory(accommodation.getCategory());
            }
            if (accommodation.getHost() != null) {
                existingAccommodation.setHost(accommodation.getHost());
            }
            if (accommodation.getNumRooms() != -1) {
                existingAccommodation.setNumRooms(accommodation.getNumRooms());
            }
            return accommodationRepository.save(existingAccommodation);
        });
    }


    @Override
    public Optional<Accommodation> setActive(Long id) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            existingAccommodation.setActive(!existingAccommodation.isActive());
            return accommodationRepository.save(existingAccommodation);
        });
    }
}
