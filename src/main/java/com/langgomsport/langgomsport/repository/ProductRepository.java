package com.langgomsport.langgomsport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.langgomsport.langgomsport.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Thêm phương thức để lọc theo giá
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
