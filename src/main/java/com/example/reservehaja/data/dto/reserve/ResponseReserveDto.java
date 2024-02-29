package com.example.reservehaja.data.dto.reserve;

import com.example.reservehaja.data.entity.Reserve;
import com.example.reservehaja.data.entity.RoundCell;
import com.example.reservehaja.data.entity.User;
import com.example.reservehaja.data.state.ReserveState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class ResponseReserveDto {

    private Long id;
    private ReserveState reserveState;
    private LocalDateTime reserveStartDate; // 예약 신청
    private String svcName;
    private LocalDate roundCellDate;
    private LocalTime useBeginTime;
    private LocalTime useEndTime;

    public ResponseReserveDto fromEntity(Reserve reserve){

        this.id = reserve.getId();
        this.reserveState = reserve.getReserveState();
        this.reserveStartDate = reserve.getReserveStartDate();
        this.svcName = reserve.getRoundCell().getRound().getAmenity().getSvcName();
        this.roundCellDate = reserve.getRoundCell().getRoundCellDate();
        useBeginTime = reserve.getRoundCell().getRound().getRoundUseBeginTime();
        useEndTime = reserve.getRoundCell().getRound().getRoundUseEndTime();

        return this;
    }


}
