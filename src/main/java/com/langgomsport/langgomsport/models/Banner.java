package com.langgomsport.langgomsport.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="banners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String image;
    private String link;
}
