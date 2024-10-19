package com.langgomsport.langgomsport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.langgomsport.langgomsport.models.Product;

import java.util.List;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByBrandId(int brandId);
    Product findById(int id);
    @Query("SELECT distinct p " +
            "FROM Product p " +
            "JOIN p.categories c " +
            "WHERE c.id IN :categoryIds")
    List<Product> findAllByCategories_Id(@Param("categoryIds") List<Integer> categoryIds);

}
