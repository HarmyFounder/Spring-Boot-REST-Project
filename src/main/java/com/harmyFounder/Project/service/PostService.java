package com.harmyFounder.Project.service;

import com.harmyFounder.Project.model.Post;
import com.harmyFounder.Project.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(Post postFromDb, Post post){
        BeanUtils.copyProperties(post,postFromDb,"id");
        return postRepository.save(post);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }

    public List<Post> findByTag(String filter) {
        return postRepository.findByTag(filter);
    }
}
