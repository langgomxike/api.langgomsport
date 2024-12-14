package com.langgomsport.langgomsport.controllers;

import com.langgomsport.langgomsport.dtos.ResponseDTO.CategoryDTO;
import com.langgomsport.langgomsport.models.Category;
import com.langgomsport.langgomsport.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public Category getCategoryById(@RequestParam int id) {
        return categoryService.getCategoryById(id);
    }

}
