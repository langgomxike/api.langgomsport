package com.langgomsport.langgomsport.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.langgomsport.langgomsport.dtos.ResponseDTO.GetAllProductDTO;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ProductDTO;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ResponseProductDetail;
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
@CrossOrigin(origins = "http://localhost:3000")
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
        List<ProductDTO> productResponse = new ArrayList<>();
        for(Product product : products) {
            List<VariantImage> images = productService.getImagesProducts(product);
            ProductDTO productDTO = new ProductDTO(product, images);
            productResponse.add(productDTO);
        }

        Pagination pagination = productService.getPagination(categoryId, sizeIds, brandIds, minPrice, maxPrice, sort, page, perPage);

        return ResponseEntity.ok( new GetAllProductDTO(productResponse, pagination));
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseProductDetail> getProductDetail(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String slug,
            @RequestParam(defaultValue = "6") Integer limit
    ){
        Product product = new Product();
        ProductDTO productResponse = new ProductDTO();
        if(id != null){
            product = productService.getProductById(id);
            List<VariantImage> images = productService.getImagesProducts(product);
            productResponse = new ProductDTO(product, images);
        } else if (slug != null) {
            product = productService.getProductBySlug(slug);
            List<VariantImage> images = productService.getImagesProducts(product);
            productResponse = new ProductDTO(product, images);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Category> categories =  product.getCategories();
        List<ProductDTO> relatedProducts = productService.getRelatedProducts(categories, product.getId(), limit);

        return ResponseEntity.ok(new ResponseProductDetail(productResponse, relatedProducts));
    }

    //demo function


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

