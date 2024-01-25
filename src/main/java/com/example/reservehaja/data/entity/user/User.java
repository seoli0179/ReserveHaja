package com.example.reservehaja.data.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // 해당 클래스가 엔티티임을 명시(* 필수)
@Table(name = "user")    //DB Table 이름 지정(생략 가능, 생략시 클래스 이름으로 생성)
@Getter //Lombok Getter 메소드 자동 생성(편의성)
@Setter //Lombok Setter 메소드 자동 생성(편의성)
public class User {

    @Id //테이블 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPassword;

    private String userName;

    private String userPhone;

    private String userEmail;

}
