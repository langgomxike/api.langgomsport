package com.langgomsport.langgomsport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.service.ProductService;

@RestController
@RequestMapping("/api/products") // Đổi đường dẫn thành /api để phân biệt với view thông thường
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        // Trả về danh sách sản phẩm dưới dạng JSON
        return productService.getAllProducts();
    }

    @GetMapping("/filter")
    public List<Product> getProductsByPriceRange(
            @RequestParam("minPrice") Double minPrice,
            @RequestParam("maxPrice") Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }
}

