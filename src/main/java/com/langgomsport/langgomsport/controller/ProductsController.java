package com.langgomsport.langgomsport.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.langgomsport.langgomsport.dtos.GetAllProductDTO;
import com.langgomsport.langgomsport.dtos.ProductDTO;
import com.langgomsport.langgomsport.dtos.ResponseProductDetail;
import com.langgomsport.langgomsport.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.langgomsport.langgomsport.service.ProductService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RequestMapping("/api/products") // Đổi đường dẫn thành /api để phân biệt với view thông thường
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<GetAllProductDTO> getAllProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) List<Integer> sizeIds,
            @RequestParam(required = false) List<Integer> brandIds,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "PRICEASC") String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int perPage
    ) {
        // Trả về danh sách sản phẩm dưới dạng JSON
        int offset = (page - 1) * perPage;
        List<ProductDTO> productDTOS = new ArrayList<>();
//        Sort sort1 = Sort.fromString(sort);
        List<Product> products =  productService.getAllProducts(categoryId, sizeIds, brandIds, minPrice, maxPrice, sort ,offset, perPage );

        Pagination pagination = productService.getPagination(categoryId, sizeIds, brandIds, minPrice, maxPrice, sort, page, perPage);

        return ResponseEntity.ok( new GetAllProductDTO(products, pagination));
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseProductDetail> getProductDetail(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String slug,
            @RequestParam(defaultValue = "6") Integer limit
    ){
        Product product = new Product();
        if(id != null){
            product = productService.getProductById(id);
        } else if (slug != null) {
            product = productService.getProductBySlug(slug);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Category> categories =  product.getCategories();
        List<Product> relatedProducts = productService.getRelatedProducts(categories, product.getId(), limit);

        return ResponseEntity.ok(new ResponseProductDetail(product, relatedProducts));
    }

    //demo function

    @GetMapping("/demo")
    public ResponseEntity<List<Product>> getDemoProduct(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) List<Integer> sizeIds,
            @RequestParam(required = false) List<Integer> brandIds,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "PRICEASC") String sort,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "20") int limit
    ) {
        List<Product> products = productService.getAllProducts(categoryId, sizeIds, brandIds, minPrice, maxPrice, sort, offset, limit);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/demo/page")
    public Pagination getPaginationDemo(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) List<Integer> sizeIds,
            @RequestParam(required = false) List<Integer> brandIds,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "PRICEASC") String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int perPage
    ){
        return productService.getPagination(categoryId, sizeIds, brandIds, minPrice, maxPrice, sort, page, perPage);
    }

}

