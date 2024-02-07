package com.example.reservehaja.data.entity;

import com.example.reservehaja.data.state.RoundCellState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "round_cell")
@Getter
@Setter
public class RoundCell {

    @Id
    private int id;

    private RoundCellState roundCellState;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate roundCellDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "round_id")
    Round round;

}
