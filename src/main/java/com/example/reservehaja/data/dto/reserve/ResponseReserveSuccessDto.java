package com.example.reservehaja.data.dto.reserve;

import com.example.reservehaja.data.entity.Reserve;
import com.example.reservehaja.data.state.ReserveState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class ResponseReserveSuccessDto {

    private Long reserveId;
    private String serviceName;
    private LocalDate useDate;
    private LocalTime useBeginTime;
    private LocalTime useEndTime;
    private int usePeople;
    private ReserveState reserveState;

    public ResponseReserveSuccessDto fromEntity(Reserve reserve){

        this.reserveId = reserve.getId();
        this.serviceName = reserve.getRoundCell().getRound().getAmenity().getSvcName();
        this.useDate = reserve.getRoundCell().getRoundCellDate();
        this.useBeginTime = reserve.getRoundCell().getRound().getRoundUseBeginTime();
        this.useEndTime = reserve.getRoundCell().getRound().getRoundUseEndTime();
        this.usePeople = 1;
        this.reserveState = reserve.getReserveState();

        return this;
    }

}
