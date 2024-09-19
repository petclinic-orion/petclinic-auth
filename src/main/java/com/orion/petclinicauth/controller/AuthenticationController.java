package com.orion.petclinicauth.controller;

import com.orion.petclinicauth.model.LoginRequest;
import com.orion.petclinicauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        logger.info("[createAuthenticationToken] Authentication user: {}", authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(authenticationRequest.getUsername() + authenticationRequest.getPassword());

        return jwt;
    }
}