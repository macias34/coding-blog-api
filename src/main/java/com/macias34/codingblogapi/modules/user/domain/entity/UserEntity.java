package com.macias34.codingblogapi.modules.user.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private int id;
    private String name;
    private String username;
    private String email;
    private String avatarSrc;
}
