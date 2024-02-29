package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.Amenity;
import com.example.reservehaja.data.state.ServiceState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    List<Amenity> findTop12ByOrderById();

}
