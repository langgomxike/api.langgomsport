package com.langgomsport.langgomsport.dtos.RequestDTO;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderVariantDTO {
    private String orderId;
    private int variantId;
    private int quantity;
}
