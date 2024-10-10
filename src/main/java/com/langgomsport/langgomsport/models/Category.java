package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int parentId;

    //getter and setter
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

    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parent_id) {
        this.parentId = parent_id;
    }

}
