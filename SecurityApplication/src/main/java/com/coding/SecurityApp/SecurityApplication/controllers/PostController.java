package com.coding.SecurityApp.SecurityApplication.controllers;

import com.coding.SecurityApp.SecurityApplication.dto.PostDto;
import com.coding.SecurityApp.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    @PreAuthorize("@postSecurity.isOwnerOfPost(#postId)")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost) {
        return postService.createNewPost(inputPost);
    }

}
