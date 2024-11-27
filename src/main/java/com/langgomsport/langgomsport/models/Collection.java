package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name="collections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "vn_name")
    private String name;
    @Column(name= "en_name")
    private String enName;
    private String image;
    @Column(name ="limit_product")
    private int limitProduct;

    //relationships
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "collection_product",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @OrderColumn(name = "position")
    private List<Product> products;
}
