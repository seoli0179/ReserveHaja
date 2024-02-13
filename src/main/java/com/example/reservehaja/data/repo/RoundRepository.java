package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {

    List<Round> findByAmenity_IdAndRoundCellList_RoundCellDateBetween(Long amenityId, LocalDate start, LocalDate end);

}
