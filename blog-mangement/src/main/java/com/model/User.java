package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int uid;

    private String name;

    @OneToMany(mappedBy="user")
    private List<Blog> blogs;

    @OneToMany(mappedBy="user")
    private List<Comment> comments;

    public User(){}

    public User(int uid,String name){
        this.uid=uid;
        this.name=name;
    }


}