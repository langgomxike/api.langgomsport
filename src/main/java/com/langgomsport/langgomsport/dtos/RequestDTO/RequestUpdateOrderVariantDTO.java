package com.langgomsport.langgomsport.dtos.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateOrderVariantDTO {
    private int variantId;
    private int quantity;
    private BigDecimal price;
}
