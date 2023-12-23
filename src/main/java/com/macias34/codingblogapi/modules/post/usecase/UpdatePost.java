package com.macias34.codingblogapi.modules.post.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.api.post.dto.UpdatePostDto;
import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import com.macias34.codingblogapi.modules.post.domain.port.PostMapper;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;
import com.macias34.codingblogapi.shared.validation.DtoValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePost {

    private final PostRepository postRepository;
    private final FindPost findPost;
    private final PostMapper postMapper;

    public void execute(int id, UpdatePostDto updatePostDto) {

        DtoValidator.validate(updatePostDto);

        PostEntity postEntity = findPost.execute(id);
        PostModel post = postMapper.mapEntityToModel(postEntity);

        if (updatePostDto.getTitle() != null) {
            post.setTitle(updatePostDto.getTitle());
        }

        if (updatePostDto.getContent() != null) {
            post.setContent(updatePostDto.getContent());
        }

        postRepository.save(post);
    }
}
