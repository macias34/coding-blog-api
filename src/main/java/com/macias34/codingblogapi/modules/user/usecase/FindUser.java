package com.macias34.codingblogapi.modules.user.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;
import com.macias34.codingblogapi.modules.user.domain.entity.UserModel;
import com.macias34.codingblogapi.modules.user.domain.exception.UserNotFoundException;
import com.macias34.codingblogapi.modules.user.domain.port.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindUser {

    private final UserRepository userRepository;

    public UserEntity execute(int id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        UserEntity userEntity = UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .avatarSrc(user.getAvatarSrc())
                .build();

        return userEntity;
    }
}
