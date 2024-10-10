package com.langgomsport.langgomsport.repository;

import com.langgomsport.langgomsport.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Dictionary;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findCategoriesByParentId(int parentId);
}
