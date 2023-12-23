package com.macias34.codingblogapi.modules.post.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.api.post.dto.CreatePostDto;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;
import com.macias34.codingblogapi.shared.validation.DtoValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreatePost {
    private final PostRepository postRepository;

    public void execute(CreatePostDto createPostDto) {

        DtoValidator.validate(createPostDto);

        PostModel post = PostModel.builder()
                .title(createPostDto.getTitle())
                .content(createPostDto.getContent())
                .build();

        postRepository.save(post);
    }
}
