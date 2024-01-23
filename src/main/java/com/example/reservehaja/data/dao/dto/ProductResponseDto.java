package com.example.reservehaja.data.dao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

}
