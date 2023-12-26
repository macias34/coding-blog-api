package com.macias34.codingblogapi.modules.auth.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.api.auth.dto.SignInDto;
import com.macias34.codingblogapi.modules.auth.domain.entity.SessionEntity;
import com.macias34.codingblogapi.modules.auth.domain.exception.WrongCredentialsException;
import com.macias34.codingblogapi.modules.auth.infrastructure.jwt.JwtGenerator;
import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;
import com.macias34.codingblogapi.modules.user.usecase.FindUserByUsername;
import com.macias34.codingblogapi.shared.validation.DtoValidator;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignIn {

    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;
    private final FindUserByUsername findUserByUsername;

    public SessionEntity execute(SignInDto signInDto) {
        DtoValidator.validate(signInDto);

        Authentication authentication = authenticate(signInDto);
        String accessToken = jwtGenerator.generateToken(authentication);

        UserEntity user = findUserByUsername.execute(signInDto.getUsername());

        SessionEntity session = SessionEntity.builder().accessToken(accessToken).user(user).build();

        return session;
    }

    private Authentication authenticate(SignInDto signInDto) {
        try {
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new WrongCredentialsException();
        }
    }
}
