package com.example.reservehaja.service.user;

import com.example.reservehaja.data.dto.user.UserJoinResponseDto;
import com.example.reservehaja.data.entity.User;
import com.example.reservehaja.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean addUser(UserJoinResponseDto dto){

        if(userRepository.findByUserEmail(dto.getUserEmail()).isEmpty()){

            User user = new User();

            user.setUserId(dto.getUserId());
            user.setUserPassword(dto.getUserPassword());
            user.setUserName(dto.getUserName());
            user.setUserPhone(dto.getUserPhone());
            user.setUserEmail(dto.getUserEmail());

            userRepository.save(user);

            return true;
        }

        return false;

    }

    public boolean isEmptyUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail).isEmpty();
    }

}
