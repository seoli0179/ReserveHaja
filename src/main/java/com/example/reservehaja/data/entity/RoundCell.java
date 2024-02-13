package com.example.reservehaja.data.entity;

import com.example.reservehaja.data.state.RoundCellState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roundCell")
@Getter
@Setter
@ToString
public class RoundCell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoundCellState roundCellState;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate roundCellDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "round_id")
    Round round;

    @OneToMany(mappedBy = "roundCell", cascade = CascadeType.REMOVE)
    private List<Reserve> reserveList = new ArrayList<>();

}
