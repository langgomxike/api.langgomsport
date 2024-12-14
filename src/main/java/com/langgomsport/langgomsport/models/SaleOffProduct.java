package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "sale_off_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOffProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name= "product_id")
    private Product product;
}
