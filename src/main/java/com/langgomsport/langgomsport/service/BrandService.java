package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.dtos.BrandDTO;
import com.langgomsport.langgomsport.models.Brand;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.repository.BrandRepository;
import com.langgomsport.langgomsport.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<BrandDTO> getAllBrands() {
        // Lấy tất cả thương hiệu từ cơ sở dữ liệu
        List<Brand> brands = brandRepository.findAll();

        // Chuyển đổi từ Brand sang BrandDTO
        return brands.stream().map(brand -> new BrandDTO(brand.getId(), brand.getName())).collect(Collectors.toList());
    }

    // lấy sản phầm từ id thương hiệu
    public List<Product> getAllProductsByBrand(int brandId) {
        return productRepository.findByBrandId(brandId);
    }
}
