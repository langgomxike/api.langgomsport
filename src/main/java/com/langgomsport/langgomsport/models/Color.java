package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "colors")
public class Color {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    private String name;

    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    //relationships
    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private List<Variant> variants;


}
