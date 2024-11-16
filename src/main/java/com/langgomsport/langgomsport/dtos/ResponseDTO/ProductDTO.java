package com.langgomsport.langgomsport.dtos.ResponseDTO;

import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.models.VariantImage;
import lombok.*;

import java.util.List;


@Data
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    //properties
    private Product product;
    private List<VariantImage> images;

}
