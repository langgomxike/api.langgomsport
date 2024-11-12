package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.OrderVariant;
import com.langgomsport.langgomsport.models.Variant;
import com.langgomsport.langgomsport.models.serialize.OrderVariantId;
import com.langgomsport.langgomsport.repository.OrderRepository;
import com.langgomsport.langgomsport.repository.OrderVariantRepository;
import com.langgomsport.langgomsport.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderVariantService {
    @Autowired
    private OrderVariantRepository orderVariantRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private VariantRepository variantRepository;

    public OrderVariant saveOrderVariant(String orderId, int variantId, int quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("order not found!"));
        Variant variant = variantRepository.findById(variantId)
                .orElseThrow(()-> new RuntimeException("variant not found!"));

        OrderVariantId orderVariantId = new OrderVariantId(orderId, variantId);

        OrderVariant orderVariant = new OrderVariant();
            orderVariant.setId(orderVariantId);
            orderVariant.setOrder(order);
            orderVariant.setVariant(variant);
            orderVariant.setQuantity(quantity);

            return orderVariantRepository.save(orderVariant);
    }

    public void deleteOrderVariant(String orderId, int variantId) {
        OrderVariantId id = new OrderVariantId(orderId, variantId);
        orderVariantRepository.deleteById(id);
    }

    public OrderVariant updteOrderVariant(String orderId, int variantId, int quantity) {
        OrderVariantId orderVariantId = new OrderVariantId(orderId, variantId);
        OrderVariant orderVariant = orderVariantRepository.findById(orderVariantId)
                .orElseThrow(()-> new RuntimeException("cart item not found!"));

        orderVariant.setQuantity(quantity);
        return orderVariantRepository.save(orderVariant);
    }

    public List<OrderVariant> getOrderVariantsByOrderId(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("order not found!"));
        return orderVariantRepository.getAllByOrder(order);
    }

    public int getAllOrderVariantsCount(String orderId) {
        List<OrderVariant> orderVariants = getOrderVariantsByOrderId(orderId);
        int total = 0;
        for (OrderVariant orderVariant : orderVariants) {
            total += orderVariant.getQuantity();
        }
        return total;
    }

    public BigDecimal getAllOrderVariantsPrice(String orderId) {
        List<OrderVariant> orderVariants = getOrderVariantsByOrderId(orderId);
        BigDecimal total = new BigDecimal(0);
        for (OrderVariant orderVariant : orderVariants) {
            BigDecimal priceItem = orderVariant.getVariant().getPrice().multiply(new BigDecimal(orderVariant.getQuantity()));
            total = total.add(priceItem);
        }
        return total;
    }

}
