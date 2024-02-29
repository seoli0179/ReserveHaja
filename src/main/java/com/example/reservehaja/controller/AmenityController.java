package com.example.reservehaja.controller;

import com.example.reservehaja.data.dto.amenity.ResponseAmenityDetailDto;
import com.example.reservehaja.data.dto.amenity.ResponseAmenityDto;
import com.example.reservehaja.data.entity.Amenity;
import com.example.reservehaja.service.amenity.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amenity")
public class AmenityController {

    private final AmenityService amenityService;

    @GetMapping("/recommend")
    public List<ResponseAmenityDto> listAmenity() {

        List<ResponseAmenityDto> dtoList = new ArrayList<>();
        List<Amenity> amenityList = amenityService.readAmenityArray();

        for(Amenity amenity : amenityList){
            ResponseAmenityDto dto = new ResponseAmenityDto();
            dtoList.add(dto.fromEntity(amenity));
        }

        return dtoList;
    }

    @GetMapping()
    public List<ResponseAmenityDto> readAmenityAll() {

        List<ResponseAmenityDto> dtoList = new ArrayList<>();
        List<Amenity> amenityList = amenityService.readAmenityAll();

        for(Amenity amenity : amenityList){
            ResponseAmenityDto dto = new ResponseAmenityDto();
            dtoList.add(dto.fromEntity(amenity));
        }

        return dtoList;
    }

    @GetMapping("/read")
    public ResponseAmenityDetailDto detailAmenity(@RequestParam("id") Long id) {

        Optional<Amenity> amenity = amenityService.readAmenity(id);
        ResponseAmenityDetailDto dto = new ResponseAmenityDetailDto();

        if(amenity.isPresent()){
            return dto.fromEntity(amenity.get());
        }

        return null;
    }

}
