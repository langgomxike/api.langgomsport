package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.dtos.CategoryDTO;
import com.langgomsport.langgomsport.models.Category;
import com.langgomsport.langgomsport.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/categories")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategoriesDTO();
    }

    @GetMapping("/without-parent")
    public List<Category> getAllCategoriesWithoutParent(){
        return categoryService.getAllCategoriesWithoutParent();
    }


}
