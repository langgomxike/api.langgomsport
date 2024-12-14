package com.langgomsport.langgomsport.repositories;

import com.langgomsport.langgomsport.models.VariantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VariantImageRepository extends JpaRepository<VariantImage, Integer> {

    @Query("SELECT vi FROM VariantImage vi JOIN vi.variant v JOIN  v.product p where p.id = :productId ")
    List<VariantImage> findAllByProductId(@Param("productId") int productId);
}
