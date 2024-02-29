package com.example.reservehaja.data.entity;

import com.example.reservehaja.data.state.ServiceState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "amenity")
@Getter
@Setter
@ToString
public class Amenity {

    @Id //테이블 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String svcId; // 서비스Id

    @Enumerated(EnumType.STRING)
    private ServiceState svcStateName; // 서비스 상태

    private String imageUrl; // 이미지 경로

    private String svcName; // 서비스 명

    private String placeName; // 장소명

    private String areaName; // 지역명

    private String userTargetInfo; // 서비스 대상

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime rcptBeginDate; // 접수시작일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime rcptEndDate; // 접수종료일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime svcOpenBeginDate; // 서비스개시 시작일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime svcOpenEndDate; // 서비스개시 종료일시

    private LocalTime svcUseBeginTime; // 서비스이용 시작시간

    private LocalTime svcUseEndTime; // 서비스이용 종료시간

    private String placeX; // 장소X좌표

    private String placeY; // 장소Y좌표

    private int numberPeople;

    private int rcptLimitDay;

    @Column(columnDefinition = "TEXT")
    private String detailInfo; // 상세정보

    private String revokeStandDayName; // 취소기간 기준정보

    @ManyToOne(fetch = FetchType.EAGER, optional = false) //optional = false -> Not null
    @JoinColumn(name = "adminId")
    private Admin admin;

    @OneToMany(mappedBy = "amenity", cascade = CascadeType.REMOVE)
    private List<Round> roundList = new ArrayList<>();



}
