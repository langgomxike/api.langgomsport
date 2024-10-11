package com.langgomsport.langgomsport.dtos;

import com.langgomsport.langgomsport.models.File;
import com.langgomsport.langgomsport.models.Product;

import java.util.List;

public class ProductDTO {
    //properties
    private Product product;
    private List<File> files;
    //getter and setter
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    //constructor

    public ProductDTO(Product product, List<File> files) {
        this.product = product;
        this.files = files;
    }
    public ProductDTO() {}
}
