package com.macias34.codingblogapi.api.auth.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {

    @NotNull
    @Size(min = 3, max = 100)
    private String username;

    @NotNull
    @Size(min = 3)
    private String password;

}