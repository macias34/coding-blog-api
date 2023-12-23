package com.macias34.codingblogapi.modules.post.usecase;

import org.springframework.stereotype.Service;

import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import com.macias34.codingblogapi.modules.post.domain.port.PostMapper;
import com.macias34.codingblogapi.modules.post.domain.port.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletePost {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final FindPost findPost;

    public void execute(int id) {

        PostModel post = postMapper.mapEntityToModel(findPost.execute(id));

        postRepository.delete(post);
    }
}
