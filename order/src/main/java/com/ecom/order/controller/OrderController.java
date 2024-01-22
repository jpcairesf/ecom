package com.ecom.order.controller;

import com.ecom.order.dto.input.OrderCreateInput;
import com.ecom.order.dto.input.OrderUpdateInput;
import com.ecom.order.dto.output.OrderOutput;
import com.ecom.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderOutput> create(@RequestBody OrderCreateInput input) {
        return status(CREATED).body(service.create(input));
    }

    @GetMapping
    public ResponseEntity<List<OrderOutput>> findAllOrderByOrderNumber() {
        return status(OK).body(service.findAll());
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<OrderOutput> findByOrderNumber(@PathVariable String orderNumber) {
        return status(OK).body(service.findByOrderNumber(orderNumber));
    }

    @PatchMapping
    public ResponseEntity<OrderOutput> update(@RequestBody OrderUpdateInput input) {
        return status(OK).body(service.update(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return status(OK).build();
    }

}
