package com.eazybytes.accounts.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${app.version:unknown}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Versioned API")
                        .version(appVersion)
                        .description("Auto versioned using Git or semantic versioning"));
    }
}
