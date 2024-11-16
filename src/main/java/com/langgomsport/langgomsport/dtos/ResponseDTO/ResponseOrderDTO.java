package com.langgomsport.langgomsport.dtos.ResponseDTO;

import com.langgomsport.langgomsport.models.Order;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDTO {
    private String message;
    private Order order;
}
