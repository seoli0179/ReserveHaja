package com.example.reservehaja.controller;

import com.example.reservehaja.data.dto.round.ResponseRoundDto;
import com.example.reservehaja.data.entity.Round;
import com.example.reservehaja.data.repo.AmenityRepository;
import com.example.reservehaja.service.amenity.AmenityService;
import com.example.reservehaja.service.round.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {

    private final RoundService roundService;

    @GetMapping("/read")
    public List<ResponseRoundDto> readRound(@RequestParam("id") Long id, @RequestParam("date") String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate localDate = formatter.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        List<ResponseRoundDto> dtoList = new ArrayList<>();
        List<Round> roundList = roundService.readRoundList(id, localDate);


        for (Round round : roundList) {
            ResponseRoundDto dto = new ResponseRoundDto();
            dtoList.add(dto.fromEntity(round, localDate));
        }

        System.out.println(id + "/" + date);

        return dtoList;
    }

}
