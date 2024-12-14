package com.langgomsport.langgomsport.controllers;


import com.langgomsport.langgomsport.dtos.RequestDTO.*;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ResponseCartCountDTO;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ResponseCartDTO;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ResponseOrderDTO;
import com.langgomsport.langgomsport.models.Order;
import com.langgomsport.langgomsport.models.OrderVariant;
import com.langgomsport.langgomsport.models.Variant;
import com.langgomsport.langgomsport.services.OrderService;
import com.langgomsport.langgomsport.services.OrderVariantService;
import com.langgomsport.langgomsport.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/carts")
public class CartsController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderVariantService orderVariantService;
    @Autowired
    private VariantService variantService;

    @RequestMapping
    public ResponseEntity<ResponseCartDTO> getOrderById(@RequestParam String id) {
        Order cart = orderService.getOrder(id);
        List<OrderVariant> cartItems = orderVariantService.getOrderVariantsByOrderId(id);
        int totalItem = orderVariantService.getAllOrderVariantsCount(id);
        ResponseCartDTO cartDTO = new ResponseCartDTO(cart, cartItems, totalItem);
        return ResponseEntity.ok(cartDTO);
    }

    @PostMapping("/create-cart")
    public ResponseEntity<Order> createOrder() {
        return ResponseEntity.ok(orderService.createOrder());
    }

    @PostMapping("/add-item")
    public ResponseEntity<OrderVariant> saveOrderVariant(
            @RequestBody RequestOrderVariantDTO requestOrderVariantDTO) {

        OrderVariant orderVariant = orderVariantService.saveOrderVariant(
                requestOrderVariantDTO.getOrderId(),
                requestOrderVariantDTO.getVariantId(),
                requestOrderVariantDTO.getQuantity());
        return ResponseEntity.ok(orderVariant);
    }

    @DeleteMapping("/{orderId}/{variantId}")
    public ResponseEntity<String> deleteOrderVariant(
            @PathVariable String orderId,
            @PathVariable int variantId) {
        try {
            orderVariantService.deleteOrderVariant(orderId, variantId);
            return ResponseEntity.ok("this item delete successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("this item delete failed");
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrderVariant(
            @PathVariable String orderId,
            @RequestBody RequestUpdateOrderVariantDTO requestUpdateOrderVariantDTO){
        try {
            orderVariantService.updateOrderVariant(
                    orderId,
                    requestUpdateOrderVariantDTO.getVariantId(),
                    requestUpdateOrderVariantDTO.getQuantity());
            return ResponseEntity.ok("this item update successfully");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("this item update failed");
        }
    }

    @RequestMapping("/total")
    public ResponseEntity<ResponseCartCountDTO> getTotalCartItem(
            @RequestParam String id
    ){
        int totalItem = orderVariantService.getAllOrderVariantsCount(id);
        BigDecimal totalPrice = orderVariantService.getAllOrderVariantsPrice(id);
        return ResponseEntity.ok(new ResponseCartCountDTO(totalItem, totalPrice));
    }

    @PostMapping("/order")
    public ResponseEntity<ResponseOrderDTO> Order(
            @RequestBody RequestOrderDTO requestOrderDTO){
        try {
            Order order = orderService.order(
                    requestOrderDTO.getOrderId(),
                    requestOrderDTO.getFullName(),
                    requestOrderDTO.getPhoneNumber());

            return ResponseEntity.ok(new ResponseOrderDTO("order successfully", order));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseOrderDTO("can't Order", null));
        }
    }

    @GetMapping("/variants")
    public ResponseEntity<List<Variant>> getVariantsByIds(
            @RequestParam List<Integer> ids
    ){
        List<Variant> variants = variantService.getAllVariantsByIds(ids);
        return ResponseEntity.ok().body(variants);
    }

    @PostMapping("/multi-order")
    public ResponseEntity<ResponseOrderDTO> multiOrder(
            @RequestBody RequestMultiOrder requestMultiOrder
    ){
        Order order = orderService.save(requestMultiOrder.getFullName(), requestMultiOrder.getPhoneNumber());
        //add orderVariant
        List<OrderVariant> orderVariants = orderVariantService.saveOrderVariants(order.getId(), requestMultiOrder.getOrderVariants());
        //create order
        return ResponseEntity.ok(new ResponseOrderDTO("order successfully", order));
    }

}
