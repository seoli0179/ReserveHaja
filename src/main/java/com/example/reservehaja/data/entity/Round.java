package com.example.reservehaja.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "round")
@Getter
@Setter
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roundName;

    private String roundDates;

    private LocalTime roundUseBeginTime;

    private LocalTime roundUseEndTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "amenity_id")
    Amenity amenity;

}
