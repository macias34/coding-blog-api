package com.macias34.codingblogapi.modules.auth.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtEntity {

    private String accessToken;
}
