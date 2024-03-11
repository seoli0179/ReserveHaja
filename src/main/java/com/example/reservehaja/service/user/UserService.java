package com.example.reservehaja.service.user;

import com.example.reservehaja.data.dto.user.UserJoinResponseDto;
import com.example.reservehaja.data.entity.User;
import com.example.reservehaja.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean addUser(UserJoinResponseDto dto){

        if(userRepository.findByUserEmail(dto.getUserEmail()).isEmpty()){

            User user = new User();

            user.setUserId(dto.getUserId());
            user.setUserPassword(passwordEncoder.encode(dto.getUserPassword()));
            user.setUserName(dto.getUserName());
            user.setUserPhone(dto.getUserPhone());
            user.setUserEmail(dto.getUserEmail());

            userRepository.save(user);

            return true;
        }

        return false;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("abcdefg:" +username);
        User user = userRepository.findById(username).orElseThrow(()->new UsernameNotFoundException("존재하지 않는 계정입니다."));

        return org.springframework.security.core.userdetails.User.builder().username(user.getUserId()).password(user.getUserPassword()).build();
    }
}
