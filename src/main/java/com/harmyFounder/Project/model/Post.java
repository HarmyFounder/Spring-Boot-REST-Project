package com.harmyFounder.Project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    Set<Comment> comments;

    public Post() {
    }

    public Post(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
