package com.orion.petclinicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class PetclinicAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetclinicAuthApplication.class, args);
    }

}
