package com.example.reservehaja.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // 해당 클래스가 엔티티임을 명시(* 필수)
@Table(name = "admin")    //DB Table 이름 지정(생략 가능, 생략시 클래스 이름으로 생성)
@Getter //Lombok Getter 메소드 자동 생성(편의성)
@Setter //Lombok Setter 메소드 자동 생성(편의성)
public class Admin {


    //@Id //테이블 기본키 지정
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    @Id   //테이블 컬럼 지정(별다른 설정 없을 시 생략 가능)
    private String adminId;

    @Column(nullable = false)
    private String adminPassword;

    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false)   //테이블 컬럼 지정(별다른 설정 없을 시 생략 가능)
    private String adminPhone;

    @Column(nullable = false)   //테이블 컬럼 지정(별다른 설정 없을 시 생략 가능)
    private String adminZip;

    @Column(nullable = false, unique = true)   //테이블 컬럼 지정(별다른 설정 없을 시 생략 가능)
    private String adminEmail;

}
