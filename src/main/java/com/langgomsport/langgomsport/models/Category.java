package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JoinColumn(name = "parent_id")
//    @JsonIgnore// ánh xạ với cột parent_id trong cơ sở dữ liệu
    private Category parent;

    //relationships
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

//    private int parentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        if (this.parent != null && this.parent.getId() != 0) {
            return this.parent;
        }
        return null;  // Trả về null nếu parent_id = 0
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
