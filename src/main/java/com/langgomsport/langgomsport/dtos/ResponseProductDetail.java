package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.Product;

import java.util.List;

public class ResponseProductDetail {
    //properties
    private Product product;
    private List<Product> related_products;

    //getter and setter
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getRelated_products() {
        return related_products;
    }
    public void setRelated_products(List<Product> related_products) {
        this.related_products = related_products;
    }

    //constructor
    public ResponseProductDetail(Product product, List<Product> related_products) {
        this.product = product;
        this.related_products = related_products;
    }

    public ResponseProductDetail() {
    }
}
