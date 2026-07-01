package com.coding.SecurityApp.SecurityApplication.services;

import com.coding.SecurityApp.SecurityApplication.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
}
