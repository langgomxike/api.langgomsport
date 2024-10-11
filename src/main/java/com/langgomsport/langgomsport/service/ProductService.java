package com.langgomsport.langgomsport.service;

import java.math.BigDecimal;
import java.util.List;

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
public class ProductService {
    private static final Log log = LogFactory.getLog(ProductService.class);
    @Autowired
    private ProductRepository productService;
    @Autowired
    private EntityManager em ;

//    //Get all product
//    public List<Product> getAllProducts(){
//        return productService.findAll();
//    }


    //get All product with native query

    public List<Product> getAllProducts(
            Integer categoryId,
            Integer sizeId,
            Integer brandId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Boolean sort,
            int offset,
            int limit
    ){
        StringBuilder sql = new StringBuilder("SELECT p.* FROM products p " +
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
        if (sizeId != null) {
            sql.append("AND s.id = :sizeId ");
        }
        if (brandId != null) {
            sql.append("AND b.id = :brandId ");
        }
        if (minPrice != null) {
            sql.append("AND p.price >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND p.price <= :maxPrice ");
        }

        // Thêm điều kiện sắp xếp
        sql.append("ORDER BY ");
        if (sort) {
            sql.append("p.price ASC ");
        } else {
            sql.append("p.price DESC ");
        }
        // them phan trang
        sql.append("LIMIT :limit OFFSET :offset");
        Query query = em.createNativeQuery(sql.toString(), Product.class);

        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (sizeId != null) {
            query.setParameter("sizeId", sizeId);
        }
        if (brandId != null) {
            query.setParameter("brandId", brandId);
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

    public Pagination getPagination(
            Integer categoryId,
            Integer sizeId,
            Integer brandId,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Boolean sort,
            int page,
            int perPage
    ){
        int offset = (page - 1) * perPage;

        // Tính tổng số sản phẩm co bo loc để tính totalPages
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM products p " +
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
        if (sizeId != null) {
            sql.append("AND s.id = :sizeId ");
        }
        if (brandId != null) {
            sql.append("AND b.id = :brandId ");
        }
        if (minPrice != null) {
            sql.append("AND p.price >= :minPrice ");
        }
        if (maxPrice != null) {
            sql.append("AND p.price <= :maxPrice ");
        }

        // Thêm điều kiện sắp xếp
        sql.append("ORDER BY ");
        if (sort) {
            sql.append("p.price ASC ");
        } else {
            sql.append("p.price DESC ");
        }

        //tao cau truy van
        Query countQuery = em.createNativeQuery(sql.toString());
        //anh xa du lieu vao cau truy van
        if (categoryId != null) {
            countQuery.setParameter("categoryId", categoryId);
        }
        if (sizeId != null) {
            countQuery.setParameter("sizeId", sizeId);
        }
        if (brandId != null) {
            countQuery.setParameter("brandId", brandId);
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

    public List<File> getProductFiles(Product product) {
        StringBuilder sql = new StringBuilder("select f.* from files f " +
            "LEFT JOIN variant_file vf ON vf.file_id = f.id " +
            "LEFT JOIN variants v ON vf.variant_id = v.id " +
            "LEFT JOIN products p ON p.id = v.product_id " +
            "WHERE p.id = :productId ");
        Query query = em.createNativeQuery(sql.toString(), File.class);
        query.setParameter("productId", product.getId());
        return (List<File>) query.getResultList();
    }

}
