package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.Pagination;
import com.langgomsport.langgomsport.models.Product;

import java.util.List;

public class GetAllProductDTO {
    //properties
    private List<ProductDTO> products;
    private Pagination pagination;

    //getter & setter
    public List<ProductDTO> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
    public Pagination getPagination() {
        return pagination;
    }
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    //constructor
    public GetAllProductDTO(List<ProductDTO> products, Pagination pagination) {
        this.products = products;
        this.pagination = pagination;
    }
}
