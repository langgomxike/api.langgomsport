package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "homepage_brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
