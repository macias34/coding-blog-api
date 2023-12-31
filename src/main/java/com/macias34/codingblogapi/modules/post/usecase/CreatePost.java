package com.macias34.codingblogapi.modules.post.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.api.post.dto.CreatePostDto;
import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import com.macias34.codingblogapi.modules.post.domain.port.PostMapper;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;
import com.macias34.codingblogapi.modules.user.domain.entity.UserModel;
import com.macias34.codingblogapi.modules.user.domain.port.UserMapper;
import com.macias34.codingblogapi.modules.user.usecase.FindUser;
import com.macias34.codingblogapi.shared.validation.DtoValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreatePost {
    private final PostRepository postRepository;
    private final FindUser findUser;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public PostEntity execute(CreatePostDto createPostDto) {

        DtoValidator.validate(createPostDto);

        UserModel author = userMapper.mapEntityToModel(findUser.execute(createPostDto.getAuthorId()));

        PostModel post = PostModel.builder()
                .author(author)
                .build();

        return postMapper.mapModelToEntity(postRepository.save(post));
    }
}
