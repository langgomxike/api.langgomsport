package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.Size;
import com.langgomsport.langgomsport.repository.SizeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private EntityManager em ;

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
    public List<Size> getSizebyCategories(Integer categoryId) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT s.* FROM `variants` v " +
                "RIGHT JOIN sizes s ON s.id = v.size_id " +
                "LEFT JOIN products_in_categories pc ON pc.product_id = v.product_id " +
                "LEFT JOIN categories c ON c.id = pc.category_id ");

        sql.append("WHERE 1=1 ");
        if(categoryId != null) {
            sql.append(" AND c.id = :categoryId ");
        }

        //sort
        sql.append(" ORDER BY id ASC ");

        Query query = em.createNativeQuery(sql.toString(), Size.class);
        if(categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }

        return (List<Size>) query.getResultList();
    }
}
