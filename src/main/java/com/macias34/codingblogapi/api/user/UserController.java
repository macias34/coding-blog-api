package com.macias34.codingblogapi.api.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;
import com.macias34.codingblogapi.modules.user.usecase.FindUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final FindUser findUser;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUser(@PathVariable int id) {

        UserEntity user = findUser.execute(id);
        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
    }

}
