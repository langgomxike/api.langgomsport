package com.langgomsport.langgomsport.services;

import com.langgomsport.langgomsport.models.Brand;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.repositories.BrandRepository;
import com.langgomsport.langgomsport.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Brand> getAllBrands() {
        // Lấy tất cả thương hiệu từ cơ sở dữ liệu
        List<Brand> brands = brandRepository.findAll();

        // Chuyển đổi từ Brand sang BrandDTO
        return brands;
    }

    // lấy sản phầm từ id thương hiệu
    public List<Product> getAllProductsByBrand(int brandId) {
        return productRepository.findByBrandId(brandId);
    }
}
