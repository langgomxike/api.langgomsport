package com.langgomsport.langgomsport.repositories;

import com.langgomsport.langgomsport.models.NewestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewestProductRepository extends JpaRepository<NewestProduct, Integer> {
}
