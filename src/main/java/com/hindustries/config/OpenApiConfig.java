package com.hindustries.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        servers = {
                @Server(url = "/")
        }
)
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("FARM MASTER API")
                        .description("FARM RESTFULL API")
                        .version("1.0.0"));
    }
}
