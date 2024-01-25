package com.example.reservehaja.service.user;

import com.example.reservehaja.data.dao.dto.user.SecurityUserDto;
import com.example.reservehaja.data.entity.user.User;
import com.example.reservehaja.data.repo.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // request Header에서 AccessToken을 가져온다.
        String atc = request.getHeader("Authorization"); //Illegal base64url character: ' '에러  'Bearer ' 라는 공백 인식에러
        if(atc != null) atc = atc.replaceAll("Bearer ","");
        System.out.println("doFilterInternal : " + atc);

        // 토큰 검사 생략(모두 허용 URL의 경우 토큰 검사 통과)
        if (!StringUtils.hasText(atc)) {
            doFilter(request, response, filterChain);
            return;
        }

        // AccessToken을 검증하고, 만료되었을경우 예외를 발생시킨다.
        if (!jwtUtil.verifyToken(atc)) {
            throw new JwtException("Access Token 만료!");
        }

        // AccessToken의 값이 있고, 유효한 경우에 진행한다.
        if (jwtUtil.verifyToken(atc)) {
            System.out.println("들어감");
            // AccessToken 내부의 payload에 있는 email로 user를 조회한다. 없다면 예외를 발생시킨다 -> 정상 케이스가 아님
            User findUser = userRepository.findByUserEmail(jwtUtil.getUid(atc))
                    .orElseThrow(IllegalStateException::new);
            System.out.println("예외X");
            // SecurityContext에 등록할 User 객체를 만들어준다.
            SecurityUserDto userDto = new SecurityUserDto(findUser.getUserId(),findUser.getUserName(),findUser.getUserEmail());

            // SecurityContext에 인증 객체를 등록해준다.
            Authentication auth = getAuthentication(userDto);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }



    public Authentication getAuthentication(SecurityUserDto user) {
        return new UsernamePasswordAuthenticationToken(user, "", List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }

}
