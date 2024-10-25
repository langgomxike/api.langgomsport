package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.Pagination;
import com.langgomsport.langgomsport.models.Product;

import java.util.List;

public class GetAllProductDTO {
    //properties
    private List<Product> products;
    private Pagination pagination;

    //getter & setter
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Pagination getPagination() {
        return pagination;
    }
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    //constructor
    public GetAllProductDTO(List<Product> products, Pagination pagination) {
        this.products = products;
        this.pagination = pagination;
    }
}
