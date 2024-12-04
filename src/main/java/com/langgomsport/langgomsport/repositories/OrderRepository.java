package com.langgomsport.langgomsport.repositories;

import com.langgomsport.langgomsport.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
