package com.langgomsport.langgomsport.dtos.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartCountDTO {
    private int totalItem;
    private BigDecimal totalPrice;
}
