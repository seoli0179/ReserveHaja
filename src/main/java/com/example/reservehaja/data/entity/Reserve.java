package com.example.reservehaja.data.entity;

import com.example.reservehaja.data.state.ReserveState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserve")
@Getter
@Setter
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReserveState reserveState;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S", timezone = "Asia/Seoul")
    private LocalDateTime reserveStartDate; // 예약 신청

    @ManyToOne
    @JoinColumn(name = "roundCell_id")
    private RoundCell roundCell;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
