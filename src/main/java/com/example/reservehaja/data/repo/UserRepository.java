package com.example.reservehaja.data.repo;

import com.example.reservehaja.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserEmail(String userEmail);

    boolean existsByUserEmail (String userEmail);

}
