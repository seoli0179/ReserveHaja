package com.example.reservehaja.controller;

import com.example.reservehaja.data.dto.reserve.RequestReserveDto;
import com.example.reservehaja.data.dto.reserve.ResponseReserveDto;
import com.example.reservehaja.data.entity.Reserve;
import com.example.reservehaja.service.reserve.ReserveService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserve")
public class ReserveController {

    private final ReserveService reserveService;

    @PostMapping
    public boolean createReserve(@RequestBody RequestReserveDto dto,
                                 @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println(dto.getId() + "/" + username);
        return reserveService.createReserve(dto.getId(), username);
    }

    @GetMapping
    public List<ResponseReserveDto> readReserveArray(@AuthenticationPrincipal UserDetails userDetails) {
        List<ResponseReserveDto> dtoList = new ArrayList<>();
        String username = userDetails.getUsername();
        List<Reserve> reserveList = reserveService.readReserveArray(username);

        for (Reserve reserve : reserveList) {
            ResponseReserveDto dto = new ResponseReserveDto();
            dto = dto.fromEntity(reserve);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @GetMapping("/cancel")
    public boolean cancelReserve(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") Long id) {
        String username = userDetails.getUsername();
        return reserveService.cancelReserve(id,username);

    }

}