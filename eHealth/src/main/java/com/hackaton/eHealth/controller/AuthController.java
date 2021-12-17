package com.hackaton.eHealth.controller;



import com.hackaton.eHealth.entities.User;
import com.hackaton.eHealth.models.UserCredentials;
import com.hackaton.eHealth.repository.UserRepository;
import com.hackaton.eHealth.security.JwtTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    private final UserRepository users;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, UserRepository users) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
        this.users = users;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@RequestBody UserCredentials data) {
        try {
            String email = data.getEmail();
            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            String token = jwtTokenServices.createToken(email);
            User user = users.findByMail(email).get();

            Map<Object, Object> model = new HashMap<>();
            model.put("userId", user.getId());
            model.put("username", user.getName());
            model.put("token", token);
            model.put("status", 200);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @PostMapping("/register")
    ResponseEntity<Object> registerClient(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.save(user);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

}
