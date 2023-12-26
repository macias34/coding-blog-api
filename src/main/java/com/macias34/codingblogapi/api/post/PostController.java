package com.macias34.codingblogapi.api.post;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macias34.codingblogapi.api.post.dto.CreatePostDto;
import com.macias34.codingblogapi.api.post.dto.UpdatePostDto;
import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.usecase.CreatePost;
import com.macias34.codingblogapi.modules.post.usecase.DeletePost;
import com.macias34.codingblogapi.modules.post.usecase.FindManyPosts;
import com.macias34.codingblogapi.modules.post.usecase.FindPost;
import com.macias34.codingblogapi.modules.post.usecase.UpdatePost;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final FindPost findPost;
    private final FindManyPosts findManyPosts;
    private final CreatePost createPost;
    private final UpdatePost updatePost;
    private final DeletePost deletePost;

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> findPost(@PathVariable int id) {
        PostEntity post = findPost.execute(id);

        return new ResponseEntity<PostEntity>(post, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<PostEntity>> findAllPosts() {
        List<PostEntity> posts = findManyPosts.execute();

        return new ResponseEntity<List<PostEntity>>(posts, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PostEntity> createPost(@RequestBody CreatePostDto createPostDto) {
        PostEntity post = createPost.execute(createPostDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable int id, @RequestBody UpdatePostDto updatePostDto) {
        updatePost.execute(id, updatePostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        deletePost.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
