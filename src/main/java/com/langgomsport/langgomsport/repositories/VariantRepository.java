package com.langgomsport.langgomsport.repositories;

import com.langgomsport.langgomsport.models.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
    public List<Variant> getAllByIdIsIn(List<Integer> ids);
}
