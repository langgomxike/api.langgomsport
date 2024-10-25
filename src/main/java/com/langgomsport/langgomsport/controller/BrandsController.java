package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.dtos.BrandDTO;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/brands")
public class BrandsController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<BrandDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

    // Lấy tất cả sản phẩm theo thương hiệu (dựa vào ID thương hiệu)
    @GetMapping("/{brandId}/products")
    public List<Product> getProductsByBrandId(@PathVariable int brandId) {
        List<Product> products = brandService.getAllProductsByBrand(brandId);

        // kiem tra neu khong co san pham tra ve loi
        if (products == null || products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found for this brand");
        }
    return products;
    }
}
