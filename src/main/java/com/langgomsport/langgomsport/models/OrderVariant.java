package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.langgomsport.langgomsport.models.serialize.OrderVariantId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_variant")
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVariant {
    @EmbeddedId
    private OrderVariantId id;

    private int quantity;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name= "variant_id")
    @MapsId("variantId")
    private Variant variant;

}


