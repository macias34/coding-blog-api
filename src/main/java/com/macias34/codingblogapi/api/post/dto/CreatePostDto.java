package com.macias34.codingblogapi.api.post.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {

    @NotNull
    private Integer authorId;

    @NotNull
    @Size(min = 3, max = 100)
    private String title;

    @NotNull
    @Size(min = 3, max = 100)
    private String excerpt;

    @NotNull
    @Size(min = 3)
    private String content;

}