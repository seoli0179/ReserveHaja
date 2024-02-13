package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve,Long> {

    boolean existsByUser_UserIdAndRoundCell_Id(String username, Long roundCellId);
    List<Reserve> findByUser_UserId(String username);

    Optional<Reserve> findByIdAndUser_UserId(Long id, String username);

}
