package com.langgomsport.langgomsport.repository;

import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.OrderVariant;
import com.langgomsport.langgomsport.models.serialize.OrderVariantId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderVariantRepository extends JpaRepository<OrderVariant, OrderVariantId> {
    List<OrderVariant> getAllByOrder(Order order);
}
