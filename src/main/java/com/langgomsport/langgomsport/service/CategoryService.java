package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.dtos.CategoryDTO;
import com.langgomsport.langgomsport.models.Category;
import com.langgomsport.langgomsport.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

//    // get all categories
//    public List<Category> getAllCategories() {return categoryRepository.findAll();}

    // get all categories without parents
    public List<Category> getAllCategoriesWithoutParent(){
        return categoryRepository.findCategoriesByParentId(0);
    }
    public List<Category> getAllCategoriesWithParent(int parentId){
        return categoryRepository.findCategoriesByParentId(parentId);
    }
    // get all categories and response with dto
    public List<CategoryDTO> getAllCategoriesDTO() {
        // Lay tat ca cac categories khong co parent
        List<Category> categoriesParent = getAllCategoriesWithoutParent();
        // Tao danh sach categories tra ve
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        // lay danh sach categories co parent va dua vao mang DTO
        for (Category category : categoriesParent) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryParent(category);
            categoryDTO.setCategories( getAllCategoriesWithParent(category.getId()));
            categoriesDTO.add(categoryDTO);
        }
        return categoriesDTO;
    }
}
