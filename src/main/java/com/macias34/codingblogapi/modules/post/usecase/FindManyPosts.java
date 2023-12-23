package com.macias34.codingblogapi.modules.post.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.port.PostMapper;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindManyPosts {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostEntity> execute() {
        return postRepository.findAll().stream()
                .map(postMapper::mapModelToEntity)
                .collect(Collectors.toList());
    }
}
