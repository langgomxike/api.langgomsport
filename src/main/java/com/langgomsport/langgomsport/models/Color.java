package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "colors")
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    @Column(name = "vn_name")
    private String name;
    @Column(name = "en_name")
    private String enName;

    //relationships
    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Variant> variants;


}
