package com.langgomsport.langgomsport.services;

import com.langgomsport.langgomsport.models.Variant;
import com.langgomsport.langgomsport.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {
    @Autowired
    private VariantRepository variantRepository;

    public List<Variant> getAllVariantsByIds(List<Integer> ids) {
        return variantRepository.getAllByIdIsIn(ids);
    }
}
