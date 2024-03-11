package com.example.reservehaja.handler;

import com.example.reservehaja.data.dto.user.OAuth2Provider;
import com.example.reservehaja.data.dto.user.OAuth2UserUnlinkManager;
import com.example.reservehaja.data.dto.user.Token;
import com.example.reservehaja.data.entity.User;
import com.example.reservehaja.data.repo.HttpCookieOAuth2AuthorizationRequestRepository;
import com.example.reservehaja.data.repo.UserRepository;
import com.example.reservehaja.service.auth.CookieUtils;
import com.example.reservehaja.service.auth.JwtUtil;
import com.example.reservehaja.service.auth.OAuth2UserPrincipal;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class LoginFormAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if (authentication != null && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                String userId = ((UserDetails) authentication.getPrincipal()).getUsername();
                Optional<User> user = userRepository.findById(userId);
                // 사용자 ID를 사용하여 원하는 작업 수행
                System.out.println("Current user ID: " + userId);

                Token token = jwtUtil.generateToken(user.get().getUserEmail());

                CookieUtils.addCookie(response,"accessToken", token.getAccessToken(),1800);
                CookieUtils.addCookieNotHttpOnly(response,"loginFlag", "True",1800);
                //CookieUtils.addCookie(response,"Authorization", "Bearer " + token.getAccessToken(),3600);

                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Login successful");

            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("User not found");

    }

}
