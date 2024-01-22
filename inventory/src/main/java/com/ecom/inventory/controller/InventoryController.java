package com.ecom.inventory.controller;

import com.ecom.inventory.dto.input.InventoryCreateInput;
import com.ecom.inventory.dto.output.InventoryOutput;
import com.ecom.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    @PostMapping
    public ResponseEntity<InventoryOutput> create(@RequestBody InventoryCreateInput input) {
        return status(CREATED).body(service.create(input));
    }

    @GetMapping("/stock/{sku}")
    public ResponseEntity<Boolean> isInStockBySku(@PathVariable String sku) {
        return status(OK).body(service.isInStockBySku(sku));
    }

    @PatchMapping("/increment/{sku}")
    public ResponseEntity<Integer> incrementBySku(@PathVariable String sku) {
        return status(OK).body(service.incrementBySku(sku));
    }

    @PatchMapping("/decrement/{sku}")
    public ResponseEntity<Integer> decrementBySku(@PathVariable String sku) {
        return status(OK).body(service.decrementBySku(sku));
    }

}
