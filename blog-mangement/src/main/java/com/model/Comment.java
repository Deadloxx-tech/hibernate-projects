package com.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    private int commentid;

    private String comment;

    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    @ManyToOne
    @JoinColumn(name="blogid")
    private Blog blog;

    public Comment() {}

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {   // REQUIRED
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {   // REQUIRED
        this.blog = blog;
    }
    public Comment(int commentid, String comment){
    this.commentid = commentid;
    this.comment = comment;
   }
}