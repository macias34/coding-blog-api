package com.macias34.codingblogapi.modules.post.domain.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Integer> {

}