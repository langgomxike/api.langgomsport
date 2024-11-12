package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vn_name")
    private String vnName;

    @Column(name = "en_name")
    private String enName;

    @ManyToOne
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JoinColumn(name = "parent_id")
//    @JsonIgnore// ánh xạ với cột parent_id trong cơ sở dữ liệu
    private Category parent;

    //relationships
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


    public Category getParent() {
        if (this.parent != null && this.parent.getId() != 0) {
            return this.parent;
        }
        return null;  // Trả về null nếu parent_id = 0
    }

}
