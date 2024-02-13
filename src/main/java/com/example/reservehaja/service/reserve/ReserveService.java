package com.example.reservehaja.service.reserve;

import com.example.reservehaja.data.entity.Reserve;
import com.example.reservehaja.data.entity.RoundCell;
import com.example.reservehaja.data.entity.User;
import com.example.reservehaja.data.repo.ReserveRepository;
import com.example.reservehaja.data.repo.RoundCellRepository;
import com.example.reservehaja.data.repo.UserRepository;
import com.example.reservehaja.data.state.ReserveState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final UserRepository userRepository;
    private final RoundCellRepository roundCellRepository;

    public boolean createReserve(Long id, String username) {

        Reserve reserve = new Reserve();

        try {
            Optional<User> user = userRepository.findById(username);
            Optional<RoundCell> roundCell = roundCellRepository.findById(id);
            if (user.isPresent() && roundCell.isPresent()) {
                if (!reserveRepository.existsByUser_UserIdAndRoundCell_Id(username, roundCell.get().getId())) {
                    reserve.setUser(user.get());
                    reserve.setReserveState(ReserveState.RESERVE_JUDGE);
                    reserve.setReserveStartDate(LocalDateTime.now());
                    reserve.setRoundCell(roundCell.get());
                    reserveRepository.save(reserve);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<Reserve> readReserveArray(String username) {

        return reserveRepository.findByUser_UserId(username);

    }

    public boolean cancelReserve(Long id, String username) {

        try {
            Optional<Reserve> reserve = reserveRepository.findByIdAndUser_UserId(id, username);
            if(reserve.isPresent()){
                reserve.get().setReserveState(ReserveState.RESERVE_CANCEL);
                reserveRepository.save(reserve.get());
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;

    }
}
