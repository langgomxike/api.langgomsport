package com.langgomsport.langgomsport.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.langgomsport.langgomsport.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.langgomsport.langgomsport.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class    ProductService {
    private static final Log log = LogFactory.getLog(ProductService.class);
    @Autowired
    private ProductRepository productService;
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
            sql.append("AND p.price >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND p.price <= :maxPrice ");
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
            sql.append("AND p.price >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND p.price <= :maxPrice ");
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
        return  productService.findById(id);
    }

    public List<Product> getRelatedProducts(List<Category> categories, int currentProductId){
        // Chuyển đổi List<Category> thành List<Integer> (danh sách ID của Category)
        List<Integer> categoryIds = categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        // Gọi phương thức trong repository với danh sách categoryIds
        return productService.findRelatedProducts(categoryIds, currentProductId);
    }


}
