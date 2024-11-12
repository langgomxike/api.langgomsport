package com.langgomsport.langgomsport.repository;

import com.langgomsport.langgomsport.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
