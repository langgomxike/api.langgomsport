package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sizes")
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Size {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String size;

    //relationships
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Variant> variants;

}
