package com.brayan.appmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Enable Auditing es para la auditoria
@EnableJpaAuditing
@SpringBootApplication
public class AppMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppMusicApplication.class, args);
    }

}
