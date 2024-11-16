package com.langgomsport.langgomsport.models.serialize;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVariantId implements Serializable{
    private String orderId;
    private int variantId;


}
