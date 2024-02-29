package com.example.reservehaja.data.dto.amenity;

import com.example.reservehaja.data.entity.Amenity;
import com.example.reservehaja.data.state.ServiceState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseAmenityDto {

    private Long id;
    private ServiceState svcStateName; // 서비스 상태
    private String imageUrl; // 이미지 경로
    private String svcName; // 서비스 명
    private String placeName; // 장소명
    private LocalDateTime rcptBeginDate; // 접수시작일시
    private LocalDateTime rcptEndDate; // 접수종료일시
    private LocalDateTime svcOpenBeginDate; // 서비스개시 시작일시
    private LocalDateTime svcOpenEndDate; // 서비스개시 종료일시
    private String category;

    public ResponseAmenityDto fromEntity(Amenity amenity){

        this.id = amenity.getId();
        this.svcStateName = amenity.getSvcStateName();
        this.imageUrl = amenity.getImageUrl();
        this.svcName = amenity.getSvcName();
        this.placeName = amenity.getPlaceName();
        this.rcptBeginDate = amenity.getRcptBeginDate();
        this.rcptEndDate = amenity.getRcptEndDate();
        this.svcOpenBeginDate = amenity.getSvcOpenBeginDate();
        this.svcOpenEndDate = amenity.getRcptEndDate();
        this.category = amenity.getCategory();

        return this;

    }

}
