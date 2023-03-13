package com.example.blogcategory.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class  Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private Date time;

    public Blog() {
    }

    public Blog(int id, String name, String content, Date time) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName ="id" )
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
