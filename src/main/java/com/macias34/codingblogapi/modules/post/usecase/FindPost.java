package com.macias34.codingblogapi.modules.post.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import com.macias34.codingblogapi.modules.post.domain.exception.PostNotFoundException;
import com.macias34.codingblogapi.modules.post.domain.port.PostMapper;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPost {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostEntity execute(int id) {
        Optional<PostModel> postModelOptional = postRepository.findById(id);
        if (postModelOptional.isPresent()) {
            return postMapper.mapModelToEntity(postModelOptional.get());
        } else {
            throw new PostNotFoundException("Post with id " + id + " not found");
        }
    }
}