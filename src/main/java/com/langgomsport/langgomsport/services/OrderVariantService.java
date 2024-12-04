package com.langgomsport.langgomsport.services;

import com.langgomsport.langgomsport.dtos.RequestDTO.RequestMultiOrderVariant;
import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.OrderVariant;
import com.langgomsport.langgomsport.models.Variant;
import com.langgomsport.langgomsport.models.serialize.OrderVariantId;
import com.langgomsport.langgomsport.repositories.OrderRepository;
import com.langgomsport.langgomsport.repositories.OrderVariantRepository;
import com.langgomsport.langgomsport.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public OrderVariant updateOrderVariant(String orderId, int variantId, int quantity) {
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

    public List<OrderVariant> saveOrderVariants(String orderId, List<RequestMultiOrderVariant> orderVariants) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("order not found!"));
        List<OrderVariant> result = new ArrayList<>();
        for(RequestMultiOrderVariant requestMultiOrderVariant : orderVariants) {
            Variant variant = variantRepository.findById(requestMultiOrderVariant.getVariantId())
                    .orElseThrow(()-> new RuntimeException("variant not found!"));
            OrderVariantId orderVariantId = new OrderVariantId(orderId, variant.getId());
            OrderVariant orderVariant = new OrderVariant();
            orderVariant.setId(orderVariantId);
            orderVariant.setOrder(order);
            orderVariant.setVariant(variant);
            orderVariant.setQuantity(requestMultiOrderVariant.getQuantity());
            result.add(orderVariantRepository.save(orderVariant));
        }
        return result;
    }

}
