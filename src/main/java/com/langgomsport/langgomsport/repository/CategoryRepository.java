package com.langgomsport.langgomsport.repository;

import com.langgomsport.langgomsport.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findCategoriesByParentId(int parentId);

    @Query("SELECT c FROM Category c JOIN c.products p WHERE p.id IN :productIds")
    List<Category> findAllByProductsId(@Param("productIds") int productId);
}
