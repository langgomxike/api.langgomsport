package com.langgomsport.langgomsport.dtos.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionDTO {
    private int id;
    private String name;
    private String enName;
    private String image;
    private int limit_product;
    private List<ProductDTO> products;
}
