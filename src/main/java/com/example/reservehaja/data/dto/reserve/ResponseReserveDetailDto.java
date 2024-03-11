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
public class ResponseReserveDetailDto {

    private Long reserveId;
    private ReserveState reserveState;
    private LocalDate useDate;
    private String roundName;
    private LocalTime useBeginTime;
    private LocalTime useEndTime;
    private int usePeople;

    private String svcName;
    private String placeName;
    private String imageUrl;
    private String address;
    private String managerName;
    private String managerPhone;

    private String userName;
    private String userPhone;
    private String userAddress;

    private LocalDateTime reserveDate;




    public ResponseReserveDetailDto fromEntity(Reserve reserve){

        reserveId = reserve.getId();
        reserveState = reserve.getReserveState();
        useDate = reserve.getRoundCell().getRoundCellDate();
        roundName = reserve.getRoundCell().getRound().getRoundName();
        useBeginTime = reserve.getRoundCell().getRound().getRoundUseBeginTime();
        useEndTime = reserve.getRoundCell().getRound().getRoundUseEndTime();
        usePeople = 1;

        svcName = reserve.getRoundCell().getRound().getAmenity().getSvcName();
        placeName = reserve.getRoundCell().getRound().getAmenity().getPlaceName();
        imageUrl = reserve.getRoundCell().getRound().getAmenity().getImageUrl();
        address = "서울특별시 구로구 개봉로3길 47-5(개봉동)";
        managerName = reserve.getRoundCell().getRound().getAmenity().getAdmin().getAdminName();
        managerPhone = reserve.getRoundCell().getRound().getAmenity().getAdmin().getAdminPhone();

        userName = reserve.getUser().getUsername();
        userPhone = reserve.getUser().getUserPhone();
        userAddress = "서울특별시 강남구";

        reserveDate = reserve.getReserveStartDate();

        return this;
    }

}
