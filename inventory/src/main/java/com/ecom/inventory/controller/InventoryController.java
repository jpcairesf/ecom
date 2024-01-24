package com.ecom.inventory.controller;

import com.ecom.inventory.dto.input.InventoryCreateInput;
import com.ecom.inventory.dto.output.InventoryOutput;
import com.ecom.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<InventoryOutput>> findBySkuIn(@RequestParam List<String> skuList) {
        return status(OK).body(service.findBySkuIn(skuList));
    }

    @PatchMapping("/increment")
    public ResponseEntity<List<InventoryOutput>> incrementBySkuIn(@RequestParam List<String> skuList) {
        return status(OK).body(service.incrementBySkuIn(skuList));
    }

    @PatchMapping("/decrement")
    public ResponseEntity<List<InventoryOutput>> decrementBySkuIn(@RequestParam List<String> skuList) {
        return status(OK).body(service.decrementBySkuIn(skuList));
    }

}
