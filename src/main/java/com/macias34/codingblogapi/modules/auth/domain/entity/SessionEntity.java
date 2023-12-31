package com.macias34.codingblogapi.modules.auth.domain.entity;

import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionEntity {

    private String accessToken;
    private UserEntity user;
}
