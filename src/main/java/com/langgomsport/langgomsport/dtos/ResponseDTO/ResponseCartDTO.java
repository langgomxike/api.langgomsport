package com.langgomsport.langgomsport.dtos.ResponseDTO;

import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.OrderVariant;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartDTO {
    private Order order;
    private List<OrderVariant> orderVariants;
    private int totalItem;
}
