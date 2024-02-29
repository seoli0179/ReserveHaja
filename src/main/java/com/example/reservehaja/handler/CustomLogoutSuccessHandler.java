package com.example.reservehaja.handler;

import com.example.reservehaja.service.auth.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 쿠키를 삭제합니다. 여기서는 쿠키 이름을 'myCookieName'으로 가정합니다.
        CookieUtils.deleteCookie(request, response, "accessToken");
        CookieUtils.deleteCookie(request, response, "loginFlag");
        // 로그아웃 후 리다이렉트할 URL을 설정합니다.
        response.sendRedirect("/");
    }


}