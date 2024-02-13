package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}
