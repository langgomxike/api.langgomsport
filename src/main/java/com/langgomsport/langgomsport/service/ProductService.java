package com.langgomsport.langgomsport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productService;

    public List<Product> getAllProducts(){
        return productService.findAll();
    }
}
