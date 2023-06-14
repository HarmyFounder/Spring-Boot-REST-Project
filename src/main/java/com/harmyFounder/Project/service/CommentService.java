package com.harmyFounder.Project.service;

import com.harmyFounder.Project.model.Comment;
import com.harmyFounder.Project.model.User;
import com.harmyFounder.Project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Comment comment, User user){
        comment.setUser(user);
        commentRepository.save(comment);
        return comment;
    }

}
