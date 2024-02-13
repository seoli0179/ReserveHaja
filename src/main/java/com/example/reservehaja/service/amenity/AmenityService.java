package com.example.reservehaja.service.amenity;

import com.example.reservehaja.data.entity.Amenity;
import com.example.reservehaja.data.repo.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;

    public List<Amenity> readAmenityArray() {
        return amenityRepository.findAll();
    }

    public Optional<Amenity> readAmenity(Long id) {
        return amenityRepository.findById(id);
    }


}
