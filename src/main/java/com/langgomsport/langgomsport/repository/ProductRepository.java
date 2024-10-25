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

//    List<Product> getAll()
@Query(value = """
        WITH top_discount_products AS (
            SELECT p.* 
            FROM products p 
            JOIN products_in_categories pic ON p.id = pic.product_id 
            JOIN categories c ON pic.category_id = c.id 
            WHERE c.id IN (:categoryIds) 
            AND p.id != :currentProductId  -- Loại trừ sản phẩm hiện tại
            ORDER BY p.discount DESC 
            LIMIT 20
        ), 
        random_top_discount AS (
            SELECT * 
            FROM top_discount_products 
            ORDER BY RAND() 
            LIMIT 6
        ),
        remaining_products AS (
            SELECT p.* 
            FROM products p 
            WHERE p.id NOT IN (
                SELECT id FROM random_top_discount
            )
            AND p.id != :currentProductId  -- Loại trừ sản phẩm hiện tại trong remaining
            ORDER BY RAND() 
            LIMIT 6
        )
        SELECT * FROM random_top_discount
        UNION ALL 
        SELECT * FROM remaining_products
        LIMIT 6;
        """, nativeQuery = true)
List<Product> findRelatedProducts(@Param("categoryIds") List<Integer> categoryId, @Param("currentProductId") int currentProductI);
}
