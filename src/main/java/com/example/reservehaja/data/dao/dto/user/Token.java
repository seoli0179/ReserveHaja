package com.example.reservehaja.data.dao.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    private String accessToken;
    private String refreshToken;

}
