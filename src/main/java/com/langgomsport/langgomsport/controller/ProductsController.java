package com.langgomsport.langgomsport.controller;

import java.math.BigDecimal;
import java.util.List;

import com.langgomsport.langgomsport.dtos.ProductDTO;
import com.langgomsport.langgomsport.models.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products") // Đổi đường dẫn thành /api để phân biệt với view thông thường
public class ProductsController {

    @Autowired
    private ProductService productService;

//    @GetMapping
//    public Page<Product> getAllProducts(
//            @RequestParam(required = false) Integer categoryId,
//            @RequestParam(required = false) Integer sizeId,
//            @RequestParam(required = false) Integer brandId,
//            @RequestParam(required = false) BigDecimal minPrice,
//            @RequestParam(required = false) BigDecimal maxPrice,
//            @RequestParam(required = false, defaultValue = "true") Boolean soft,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int perPage
//    ) {
//        // Trả về danh sách sản phẩm dưới dạng JSON
//        Pageable pageable = PageRequest.of(page, perPage);
//        return productService.getAllProducts(categoryId, sizeId, brandId, minPrice, maxPrice, soft, pageable );
//    }
    @GetMapping
    public ProductDTO getAllProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer sizeId,
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "true") Boolean sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage
    ) {
        // Trả về danh sách sản phẩm dưới dạng JSON
        int offset = (page - 1) * perPage;
        List<Product> products =  productService.getAllProducts(categoryId, sizeId, brandId, minPrice, maxPrice, sort ,offset, perPage );
        Pagination pagination = productService.getPagination(categoryId, sizeId, brandId, minPrice, maxPrice, sort, page, perPage);

        return new ProductDTO(products, pagination);
    }

    @GetMapping("/demo")
    public List<Product> getDemoProduct(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer sizeId,
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "true") Boolean sort,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return productService.getAllProducts(categoryId, sizeId, brandId, minPrice, maxPrice, sort, offset, limit);
    }

    @GetMapping("/demo/page")
    public Pagination getPaginationDemo(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer sizeId,
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "true") Boolean sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage
    ){
        return productService.getPagination(categoryId, sizeId, brandId, minPrice, maxPrice, sort, page, perPage);
    }

}

