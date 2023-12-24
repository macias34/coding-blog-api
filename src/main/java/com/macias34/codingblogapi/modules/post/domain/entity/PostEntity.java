package com.macias34.codingblogapi.modules.post.domain.entity;

import java.time.LocalDateTime;

import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostEntity {

    private int id;

    private String title;

    private String excerpt;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserEntity author;
}
