package com.example.reservehaja.data.repo.user;

import com.example.reservehaja.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);

}
