package com.langgomsport.langgomsport.models.serialize;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVariantId implements Serializable{
    @Column(length = 12)
    private String orderId;

    private int variantId;


}
