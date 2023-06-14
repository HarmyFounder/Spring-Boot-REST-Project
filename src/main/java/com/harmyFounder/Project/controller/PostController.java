package com.harmyFounder.Project.controller;

import com.harmyFounder.Project.model.Post;
import com.harmyFounder.Project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable("id")Post postFromDb){
        return postService.updatePost(postFromDb,post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id")Post post){
        postService.delete(post);
    }

    @PostMapping("/filter")
    public List<Post> filterPosts(@RequestParam String filter){
        return postService.findByTag(filter);
    }

}
