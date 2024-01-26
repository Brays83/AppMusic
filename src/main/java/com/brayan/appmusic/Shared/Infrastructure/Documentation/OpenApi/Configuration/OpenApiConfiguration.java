package com.brayan.appmusic.Shared.Infrastructure.Documentation.OpenApi.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI AppMusic(){
        var openApi = new OpenAPI();

        openApi
                .info(new Info()
                        .title("AppMusic")
                        .description("Backend of music apps like sporify ")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")));
        return openApi;


    }
}
