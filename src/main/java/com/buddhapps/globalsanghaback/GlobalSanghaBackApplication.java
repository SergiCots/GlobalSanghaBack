package com.buddhapps.globalsanghaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GlobalSanghaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalSanghaBackApplication.class, args);
    }

}
