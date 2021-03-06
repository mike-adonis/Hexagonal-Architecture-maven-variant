package com.example.hexagonalarchitecture.kitchenassistant.adapter.in.web;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.OrderItemsPort;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.dtos.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
class OrderController {

    private final OrderItemsPort orderItemsPort;

    @PostMapping(path = "/order/send")
    ResponseEntity<Long> orderFoodItems(@RequestBody StockRequest request) {
        return new ResponseEntity<>(orderItemsPort.order(request), HttpStatus.OK);
    }

    @GetMapping
            (path = "/order/get/{id}")
    ResponseEntity<Order> getOrderDetails(@PathVariable Long id) {
        return new ResponseEntity<>(orderItemsPort.findById(id), HttpStatus.OK);
    }

}
