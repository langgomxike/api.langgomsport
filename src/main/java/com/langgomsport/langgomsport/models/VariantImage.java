package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "variant_image")
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VariantImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String enName;
    private String path;
    private int capacity;
    private long createdAt;
    private long updatedAt;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    @JsonIgnore
    private Variant variant;
}
