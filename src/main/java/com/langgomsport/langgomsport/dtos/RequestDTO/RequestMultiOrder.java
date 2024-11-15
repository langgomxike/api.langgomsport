package com.langgomsport.langgomsport.dtos.RequestDTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMultiOrder {
    private String orderId;
    private String fullName;
    private String phoneNumber;
    private List<RequestMultiOrderVariant> orderVariants;
}
