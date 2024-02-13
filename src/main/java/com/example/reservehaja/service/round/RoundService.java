package com.example.reservehaja.service.round;

import com.example.reservehaja.data.entity.Round;
import com.example.reservehaja.data.repo.RoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    public List<Round> readRoundList(Long amenityId, LocalDate date) {
        return roundRepository.findByAmenity_IdAndRoundCellList_RoundCellDateBetween(amenityId, date, date);
    }

}
