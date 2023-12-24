package com.macias34.codingblogapi.api.auth;

import com.macias34.codingblogapi.api.auth.dto.SignInDto;
import com.macias34.codingblogapi.modules.auth.domain.entity.JwtEntity;
import com.macias34.codingblogapi.modules.auth.usecase.SignIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private SignIn signIn;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-in")
    public ResponseEntity<JwtEntity> signIn(@RequestBody SignInDto signInDto) {

        JwtEntity jwtEntity = signIn.execute(signInDto);

        return new ResponseEntity<>(jwtEntity, HttpStatus.OK);
    }

    @PostMapping("/generate-password")
    public ResponseEntity<String> signUp(@RequestParam String password) {

        String encodedPassword = passwordEncoder.encode(password);

        return new ResponseEntity<>(encodedPassword, HttpStatus.OK);
    }
}