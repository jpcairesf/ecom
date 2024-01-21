package com.ecom.product.usecase;

import com.ecom.product.exception.supplier.ProductExceptionSupplier;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReadUseCase {

    private final ProductRepository repository;

    public Product findByName(String name) {
        return repository.findByName(name).orElseThrow(ProductExceptionSupplier.notFoundByName(name));
    }

    public List<Product> findAll() {
        return repository.findAll(Sort.by("name"));
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(ProductExceptionSupplier.notFoundById(id));
    }
}
