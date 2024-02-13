package com.example.reservehaja.data.dto.round;

import com.example.reservehaja.data.entity.Round;
import com.example.reservehaja.data.entity.RoundCell;
import com.example.reservehaja.data.state.RoundCellState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseRoundDto {

    private Long id;
    private Long roundCellId;
    private String roundName;
    private boolean state;

    public ResponseRoundDto fromEntity(Round round, LocalDate date) {
        this.id = round.getId();
        this.roundName = round.getRoundName();

        for (RoundCell roundCell : round.getRoundCellList()) {
            System.out.println(date + "/" + roundCell.getRoundCellDate());
            if (date.isEqual(roundCell.getRoundCellDate())) {
                this.roundCellId = roundCell.getId();
                state = roundCell.getRoundCellState() == RoundCellState.RESERVE_START;
            }
        }

        return this;
    }

}
