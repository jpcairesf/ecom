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
    public ResponseEntity<Integer> incrementBySkuIn(@RequestParam List<String> skuList) {
        service.incrementBySkuIn(skuList);
        return status(OK).build();
    }

    @PatchMapping("/decrement")
    public ResponseEntity<Integer> decrementBySkuIn(@RequestParam List<String> skuList) {
        service.decrementBySkuIn(skuList);
        return status(OK).build();
    }

}
