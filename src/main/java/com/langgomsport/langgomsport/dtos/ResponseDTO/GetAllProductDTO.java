package com.langgomsport.langgomsport.dtos.ResponseDTO;

import com.langgomsport.langgomsport.models.Pagination;

import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductDTO {
    //properties
    private List<ProductDTO> products;
    private Pagination pagination;


}
