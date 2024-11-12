package com.langgomsport.langgomsport.dtos.ResponseDTO;

import lombok.*;

import java.util.List;

@Data
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDetail {
    //properties
    private ProductDTO productDTO;
    private List<ProductDTO> related_products;
}
