package com.langgomsport.langgomsport.dtos;

public class BrandDTO {
    private int id;
    private String name;

    // get set
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

    // constructor
    public BrandDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandDTO() {

    }
}
