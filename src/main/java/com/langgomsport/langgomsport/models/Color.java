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
    private String name;

    //relationships
    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Variant> variants;


}
