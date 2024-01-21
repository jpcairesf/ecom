package com.ecom.product.controller;

import com.ecom.product.dto.input.ProductCreateInput;
import com.ecom.product.dto.input.ProductUpdateInput;
import com.ecom.product.dto.output.ProductOutput;
import com.ecom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductOutput> create(@RequestBody ProductCreateInput input) {
        return status(CREATED).body(service.create(input));
    }

    @GetMapping
    public ResponseEntity<List<ProductOutput>> findAll() {
        return status(OK).body(service.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductOutput> findByName(@PathVariable String name) {
        return status(OK).body(service.findByName(name));
    }

    @PutMapping
    public ResponseEntity<ProductOutput> update(@RequestBody ProductUpdateInput input) {
        return status(OK).body(service.update(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return status(OK).build();
    }

}
