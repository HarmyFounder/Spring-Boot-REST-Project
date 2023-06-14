package com.harmyFounder.Project.controller;

import com.harmyFounder.Project.model.Comment;
import com.harmyFounder.Project.model.User;
import com.harmyFounder.Project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public Comment create(@AuthenticationPrincipal User user, @RequestBody Comment comment) {
        return commentService.create(comment, user);
    }

}
