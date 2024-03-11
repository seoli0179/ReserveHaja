package com.example.reservehaja.handler;

import com.example.reservehaja.data.dto.user.OAuth2Provider;
import com.example.reservehaja.data.dto.user.OAuth2UserUnlinkManager;
import com.example.reservehaja.data.dto.user.Token;
import com.example.reservehaja.data.repo.HttpCookieOAuth2AuthorizationRequestRepository;
import com.example.reservehaja.service.auth.CookieUtils;
import com.example.reservehaja.service.auth.JwtUtil;
import com.example.reservehaja.service.auth.OAuth2UserPrincipal;
import com.example.reservehaja.service.user.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Optional;

import static com.example.reservehaja.data.repo.HttpCookieOAuth2AuthorizationRequestRepository.MODE_PARAM_COOKIE_NAME;
import static com.example.reservehaja.data.repo.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
    private final OAuth2UserUnlinkManager oAuth2UserUnlinkManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        OAuth2UserPrincipal principal = getOAuth2UserPrincipal(authentication);

        log.info("email={}, id={}, name={}, nickname={}, accessToken={}",
                principal.getUserInfo().getEmail(),
                principal.getUserInfo().getId(),
                principal.getUserInfo().getName(),
                principal.getUserInfo().getNickname(),
                principal.getUserInfo().getAccessToken()
        );

        Token token = jwtUtil.generateToken(principal.getUserInfo().getEmail());

        CookieUtils.addCookie(response,"accessToken", token.getAccessToken(),1800);
        CookieUtils.addCookieNotHttpOnly(response,"loginFlag", "True",1800);

        response.sendRedirect("/");


    }

    private OAuth2UserPrincipal getOAuth2UserPrincipal(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (principal instanceof OAuth2UserPrincipal) {
            return (OAuth2UserPrincipal) principal;
        }
        return null;
    }


}
