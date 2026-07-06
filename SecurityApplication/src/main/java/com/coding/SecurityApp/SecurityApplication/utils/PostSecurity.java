package com.coding.SecurityApp.SecurityApplication.utils;

import com.coding.SecurityApp.SecurityApplication.dto.PostDto;
import com.coding.SecurityApp.SecurityApplication.entities.User;
import com.coding.SecurityApp.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {


  private final  PostService postService;

  public  boolean isOwnerOfPost(Long postId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDto post = postService.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());
    }

}
