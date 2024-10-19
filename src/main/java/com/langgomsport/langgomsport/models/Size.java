package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sizes")
public class Size {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String size;

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String name) {
        this.size = name;
    }

    //relationships
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<Variant> variants;

}
