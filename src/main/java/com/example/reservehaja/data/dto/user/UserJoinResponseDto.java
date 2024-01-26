package com.example.reservehaja.data.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserJoinResponseDto {

    private String userId;

    private String userPassword;

    private String userName;

    private String userPhone;

    private String userEmail;

}
