package com.example.reservehaja.data.dto.amenity;

import com.example.reservehaja.data.entity.Admin;
import com.example.reservehaja.data.entity.Amenity;
import com.example.reservehaja.data.entity.Round;
import com.example.reservehaja.data.entity.RoundCell;
import com.example.reservehaja.data.state.ServiceState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseAmenityDetailDto {

    private Long id;

    private ServiceState svcStateName; // 서비스 상태

    private String imageUrl; // 이미지 경로

    private String svcName; // 서비스 명

    private String placeName; // 장소명

    private String areaName; // 지역명

    private String userTargetInfo; // 서비스 대상

    private LocalDateTime rcptBeginDate; // 접수시작일시

    private LocalDateTime rcptEndDate; // 접수종료일시

    private LocalDateTime svcOpenBeginDate; // 서비스개시 시작일시

    private LocalDateTime svcOpenEndDate; // 서비스개시 종료일시

    private String placeX; // 장소X좌표

    private String placeY; // 장소Y좌표

    private int numberPeople;

    private int rcptLimitDay;

    private String detailInfo; // 상세정보

    private String revokeStandDayName; // 취소기간 기준정보

    private List<Round> roundList = new ArrayList<>();

    public ResponseAmenityDetailDto fromEntity(Amenity amenity){

        this.id = amenity.getId();
        this.svcStateName = amenity.getSvcStateName(); // 서비스 상태
        this.imageUrl = amenity.getImageUrl(); // 이미지 경로
        this.svcName = amenity.getSvcName(); // 서비스 명
        this.placeName = amenity.getPlaceName(); // 장소명
        this.areaName = amenity.getAreaName(); // 지역명
        this.userTargetInfo = amenity.getUserTargetInfo(); // 서비스 대상
        this.rcptBeginDate = amenity.getRcptBeginDate(); // 접수시작일시
        this.rcptEndDate = amenity.getRcptEndDate(); // 접수종료일시
        this.svcOpenBeginDate = amenity.getSvcOpenBeginDate(); // 서비스개시 시작일시
        this.svcOpenEndDate = amenity.getSvcOpenEndDate(); // 서비스개시 종료일시

        this.placeX = amenity.getPlaceX(); // 장소X좌표
        this.placeY = amenity.getPlaceY(); // 장소Y좌표
        this.numberPeople = amenity.getNumberPeople();
        this.rcptLimitDay = amenity.getRcptLimitDay();
        this.detailInfo = amenity.getDetailInfo(); // 상세정보
        this.revokeStandDayName = amenity.getRevokeStandDayName(); // 취소기간 기준정보

        this.roundList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        for(Round round : amenity.getRoundList()){
            Round temp = new Round();
            temp.setId(round.getId());

            ArrayList<RoundCell> roundCells = new ArrayList<>();

            for (RoundCell roundCell : round.getRoundCellList()){

                if(currentDate.isBefore(roundCell.getRoundCellDate())){
                    RoundCell temp1 = new RoundCell();
                    temp1.setId(roundCell.getId());
                    temp1.setRoundCellState(roundCell.getRoundCellState());
                    temp1.setRoundCellDate(roundCell.getRoundCellDate());

                    roundCells.add(temp1);
                }
            }

            temp.setRoundCellList(roundCells);
            this.roundList.add(temp);
        }

        return this;

    }

}
