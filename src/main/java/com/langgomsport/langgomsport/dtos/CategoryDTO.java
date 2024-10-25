package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    //properties
    private Category categoryParent;
    private List<Category> categories;

    //getter and setter
    public Category getCategoryParent() {
        return categoryParent;
    }
    public void setCategoryParent(Category categoryParent) {
        this.categoryParent = categoryParent;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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
