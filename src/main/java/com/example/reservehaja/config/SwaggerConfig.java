package com.example.reservehaja.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "제목",
                description = "설명",
                version = "1.0.0"
        )
)
@Configuration
public class SwaggerConfig {
        @Bean
        public GroupedOpenApi chatOpenApi() {
                String[] paths = {"/product/**"};    // 명세서에 보여줄 경로 설정

                return GroupedOpenApi.builder()
                        .group("예제 API v1")
                        .pathsToMatch(paths)
                        .build();
        }
}
