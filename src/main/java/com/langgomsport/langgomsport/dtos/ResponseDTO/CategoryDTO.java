package com.langgomsport.langgomsport.dtos.ResponseDTO;

import com.langgomsport.langgomsport.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CategoryDTO {
    //getter and setter
    //properties
    private Category categoryParent;
    private List<Category> categories;

    //constructor

    public CategoryDTO(Category categoryParent, List<Category> categories) {
        this.categoryParent = categoryParent;
        this.categories = categories;
    }

    public CategoryDTO() {
        this.categoryParent = new Category();
        this.categories = new ArrayList<Category>();
    }
}
