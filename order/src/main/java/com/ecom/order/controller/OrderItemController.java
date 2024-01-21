package com.ecom.order.controller;

import com.ecom.order.dto.input.OrderItemUpdateInput;
import com.ecom.order.dto.output.OrderItemOutput;
import com.ecom.order.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-item")
public class OrderItemController {

    private final OrderItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemOutput> findById(@PathVariable Long id) {
        return status(OK).body(service.findById(id));
    }

    @PatchMapping
    public ResponseEntity<OrderItemOutput> update(OrderItemUpdateInput input) {
        return status(OK).body(service.update(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return status(OK).build();
    }

}
