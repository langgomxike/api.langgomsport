package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.Size;

public class SizeDTO {
    // properties
    private Size size;

    // getter setter
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    //constructor
    public SizeDTO(Size size) {
        this.size = size;
    }
}
