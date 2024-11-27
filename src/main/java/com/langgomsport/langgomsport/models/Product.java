package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "vn_name")
    private String name;
    @Column(name = "en_name")
    private String enName;
    @Column(name = "vn_description")
    private String description;
    @Column(name = "en_description")
    private String endescription;
    private BigDecimal price;
    private BigDecimal discount;
    @Column(name = "desc_price")
    private BigDecimal descPrice;
    private String slug;
    @Column(name = "created_at")
    private long createdAt;
    @Column(name = "updated_at")
    private long updatedAt;

    //relationship
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("product")
    private List<Variant> variants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_in_categories", // Bảng trung gian
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

//    @ManyToMany(mappedBy = "products")
//    @JsonIgnore
//    private List<Collection> collections;


}
