package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.Size;
import com.langgomsport.langgomsport.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
}
