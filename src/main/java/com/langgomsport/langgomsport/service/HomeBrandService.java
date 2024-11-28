package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.HomeBrand;
import com.langgomsport.langgomsport.repository.HomeBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeBrandService {
    @Autowired
    private HomeBrandRepository homeBrandRepository;

    public List<HomeBrand> getAllHomeBrand() {
        return homeBrandRepository.findAll();
    }
}
