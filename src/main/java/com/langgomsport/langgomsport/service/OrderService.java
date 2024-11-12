package com.langgomsport.langgomsport.service;


import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.Status;
import com.langgomsport.langgomsport.repository.OrderRepository;
import com.langgomsport.langgomsport.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StatusRepository statusRepository;


    //service
    public Order order(String orderId, String fullName, String phoneNumber){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Order not found"));
        Status status = statusRepository.findById(2)
                .orElseThrow(()-> new RuntimeException("Status not found"));

        order.setFullName(fullName);
        order.setPhoneNumber(phoneNumber);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order createOrder(){
        Order order = new Order();
        Status status = statusRepository.findById(1).get();
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order changeStatus(String orderId, int statusId) {
        Optional<Order> order = orderRepository.findById(orderId);
        Status status = statusRepository.findById(statusId).orElseThrow(()-> new RuntimeException("status not found"));
        if(order.isPresent()){
            order.get().setStatus(status);
            return orderRepository.save(order.get());
        }else{
            return null;
        }
    }

    public void delete(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        order.ifPresent(value -> orderRepository.delete(value));
    }

    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId).get();
    }

}
