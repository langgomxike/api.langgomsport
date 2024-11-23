package com.langgomsport.langgomsport.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.langgomsport.langgomsport.dtos.ResponseDTO.ProductDTO;
import com.langgomsport.langgomsport.models.*;
import com.langgomsport.langgomsport.repository.VariantImageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.langgomsport.langgomsport.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VariantImageRepository variantImageRepository;
    @Autowired
    private EntityManager em ;

    //get All product with native query

    public List<Product> getAllProducts(Integer categoryId, List<Integer> sizeIds, List<Integer> brandIds, BigDecimal minPrice, BigDecimal maxPrice, String sort, int offset, int limit
    ){
        StringBuilder sql = new StringBuilder("SELECT DISTINCT p.* FROM products p " +
                "LEFT JOIN variants v ON p.id = v.product_id " +
                "LEFT JOIN sizes s ON v.size_id = s.id " +
                "LEFT JOIN brands b ON p.brand_id = b.id ");

        // Xử lý tham số categoryId
        if (categoryId != null) {
            sql.append("JOIN products_in_categories pc ON p.id = pc.product_id ");
            sql.append("JOIN categories c ON pc.category_id = c.id ");
        }

        // Thêm điều kiện WHERE nếu có tham số nào khác
        sql.append("WHERE 1=1 ");
        if (categoryId != null) {
            sql.append("AND c.id = :categoryId ");
        }
        //kiem tra size
        if (sizeIds != null) {
            sql.append("AND s.id IN (:sizeId) ");
        }
        if (brandIds != null) {
            sql.append("AND b.id IN (:brandId) ");
        }
        if (minPrice != null) {
            sql.append("AND p.desc_price >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND p.desc_price <= :maxPrice ");
        }

        // Thêm sắp xếp dựa trên enum Sort
        Sort sort1 = Sort.fromString(sort);
        // bo qua cac discount = 0
        if(sort1.getSortBy().equals("discount")){
            sql.append("AND p.discount > 0 ");
        }
        //sap xep
        sql.append("ORDER BY ")
                .append(sort1.getSortBy())
                .append(" ")
                .append(sort1.getSortType())
                .append(" ");

        // them phan trang
        sql.append("LIMIT :limit OFFSET :offset");
        Query query = em.createNativeQuery(sql.toString(), Product.class);

        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (sizeIds != null) {
            query.setParameter("sizeId", sizeIds); //mang size
        }
        if (brandIds != null) {
            query.setParameter("brandId", brandIds); // mang brand
        }
        if (minPrice != null) {
            query.setParameter("minPrice", minPrice);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }


        query.setParameter("limit", limit);
        query.setParameter("offset", offset);
        return (List<Product>) query.getResultList();
    }

    public Pagination getPagination(Integer categoryId, List<Integer> sizeIds, List<Integer> brandIds, BigDecimal minPrice, BigDecimal maxPrice, String sort, int page, int perPage
    ){
        int offset = (page - 1) * perPage;

        // Tính tổng số sản phẩm co bo loc để tính totalPages
        StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT p.id) FROM products p " +
                "LEFT JOIN variants v ON p.id = v.product_id " +
                "LEFT JOIN sizes s ON v.size_id = s.id " +
                "LEFT JOIN brands b ON p.brand_id = b.id ");
        // Xử lý tham số categoryId
        if (categoryId != null) {
            sql.append("JOIN products_in_categories pc ON p.id = pc.product_id ");
            sql.append("JOIN categories c ON pc.category_id = c.id ");
        }
        // Thêm điều kiện WHERE nếu có tham số nào khác
        sql.append("WHERE 1=1 ");
        if (categoryId != null) {
            sql.append("AND c.id = :categoryId ");
        }
        if (sizeIds != null) {
            sql.append("AND s.id IN (:sizeId) ");
        }
        if (brandIds != null) {
            sql.append("AND b.id IN (:brandId) ");
        }
        if (minPrice != null) {
            sql.append("AND (p.price - (p.price * p.discount / 100)) >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND (p.price - (p.price * p.discount / 100)) <= :maxPrice ");
        }

        // Thêm sắp xếp dựa trên enum Sort
        Sort sort1 = Sort.fromString(sort);
        // bo qua cac discount = 0
        if(sort1.getSortBy().equals("discount")){
            sql.append("AND p.discount > 0 ");
        }
        //sap xep
        sql.append("ORDER BY ")
                .append(sort1.getSortBy())
                .append(" ")
                .append(sort1.getSortType())
                .append(" ");


        //tao cau truy van
        Query countQuery = em.createNativeQuery(sql.toString());
        //anh xa du lieu vao cau truy van
        if (categoryId != null) {
            countQuery.setParameter("categoryId", categoryId);
        }
        if (sizeIds != null) {
            countQuery.setParameter("sizeId", sizeIds);
        }
        if (brandIds != null) {
            countQuery.setParameter("brandId", brandIds);
        }
        if (minPrice != null) {
            countQuery.setParameter("minPrice", minPrice);
        }
        if (maxPrice != null) {
            countQuery.setParameter("maxPrice", maxPrice);
        }

        Long totalItems = ((Number) countQuery.getSingleResult()).longValue();

        // Tính toán số trang
        int totalPages = (int) Math.ceil((double) totalItems / perPage);

        // Trả về kết quả phân trang
        Pagination pagination = new Pagination(page, perPage, totalPages, totalItems.intValue());
        return pagination;

    }

    public Product getProductById(int id){
        if(id <= 0){
            return null;
        }
        return  productRepository.findById(id);
    }
    public Product getProductBySlug(String slug){
        return productRepository.findBySlug(slug);
    }

    public List<ProductDTO> getRelatedProducts(List<Category> categories, int currentProductId, int limit){
        // Chuyển đổi List<Category> thành List<Integer> (danh sách ID của Category)
        List<Integer> categoryIds = categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        // Gọi phương thức trong repository với danh sách categoryIds
        List<Product> products =  productRepository.findRelatedProducts(categoryIds, currentProductId, limit);
        List<ProductDTO> productsResponse = new ArrayList<>();
        for(Product product : products){
            List<VariantImage> images = getImagesProducts(product);
            ProductDTO productDTO = new ProductDTO(product, images);
            productsResponse.add(productDTO);
        }
        return productsResponse;
    }

    public List<VariantImage> getImagesProducts(Product product){
        return variantImageRepository.findAllByProductId(product.getId());
    }

    public BigDecimal getHighestPrice(Integer categoryId, List<Integer> sizeIds, List<Integer> brandIds, String sort){
        StringBuilder sql = new StringBuilder("SELECT MAX(p.desc_price) FROM products p " +
                "LEFT JOIN variants v ON p.id = v.product_id " +
                "LEFT JOIN sizes s ON v.size_id = s.id " +
                "LEFT JOIN brands b ON p.brand_id = b.id ");

        // Xử lý tham số categoryId
        if (categoryId != null) {
            sql.append("JOIN products_in_categories pc ON p.id = pc.product_id ");
            sql.append("JOIN categories c ON pc.category_id = c.id ");
        }

        // Thêm điều kiện WHERE nếu có tham số nào khác
        sql.append("WHERE 1=1   ");
        if (categoryId != null) {
            sql.append("AND c.id = :categoryId ");
        }
        //kiem tra size
        if (sizeIds != null) {
            sql.append("AND s.id IN (:sizeId) ");
        }
        if (brandIds != null) {
            sql.append("AND b.id IN (:brandId) ");
        }
        // Thêm sắp xếp dựa trên enum Sort
        Sort sort1 = Sort.fromString(sort);
        // bo qua cac discount = 0
        if(sort1.getSortBy().equals("discount")){
            sql.append("AND p.discount > 0 ");
        }
        //sap xep
        sql.append("ORDER BY ")
                .append(sort1.getSortBy())
                .append(" ")
                .append(sort1.getSortType())
                .append(" ");

        Query query = em.createNativeQuery(sql.toString());

        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (sizeIds != null) {
            query.setParameter("sizeId", sizeIds); //mang size
        }
        if (brandIds != null) {
            query.setParameter("brandId", brandIds); // mang brand
        }

        Object result = query.getSingleResult();
        return result != null ? (BigDecimal) result : BigDecimal.ZERO;
    }

}
