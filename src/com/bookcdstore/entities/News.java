package com.bookcdstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ex56_news")
public class News {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String content;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    // ======================================
    // =            Constructors            =
    // ======================================

    public News() {
    }

    public News(String content) {
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addComment(Comment comment) {
        if (comments == null)
            comments = new ArrayList<Comment>();
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }
}