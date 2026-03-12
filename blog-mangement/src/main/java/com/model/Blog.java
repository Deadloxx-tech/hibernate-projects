package com.model;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    private int blogid;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    public Blog() {}

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {   // IMPORTANT METHOD
        this.user = user;
    }
    public Blog(int blogid, String title, String content){
    this.blogid = blogid;
    this.title = title;
    this.content = content;
  }
}