package com.macias34.codingblogapi.api.post.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDto {

    @Nullable
    private Integer authorId;

    @Nullable
    @Size(min = 3, max = 100)
    private String title;

    @Nullable
    @Size(min = 3, max = 100)
    private String excerpt;

    @Nullable
    @Size(min = 3)
    private String content;

}