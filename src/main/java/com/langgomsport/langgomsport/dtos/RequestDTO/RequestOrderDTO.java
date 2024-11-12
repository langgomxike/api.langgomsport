package com.langgomsport.langgomsport.dtos.RequestDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderDTO {
    private String orderId;
    private String fullName;
    private String phoneNumber;
}
