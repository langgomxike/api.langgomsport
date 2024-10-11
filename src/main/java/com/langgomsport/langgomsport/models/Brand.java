package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    // GET SET
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

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
    }
}
