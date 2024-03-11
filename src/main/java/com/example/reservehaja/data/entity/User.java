package com.example.reservehaja.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity // 해당 클래스가 엔티티임을 명시(* 필수)
@Table(name = "user")    //DB Table 이름 지정(생략 가능, 생략시 클래스 이름으로 생성)
@Getter //Lombok Getter 메소드 자동 생성(편의성)
@Setter //Lombok Setter 메소드 자동 생성(편의성)
public class User implements UserDetails {

    @Id //테이블 기본키 지정
    private String userId;

    private String userPassword;

    private String userName;

    private String userPhone;

    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Reserve> reserves = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
