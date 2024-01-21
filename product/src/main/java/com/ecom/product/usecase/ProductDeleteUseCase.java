package com.ecom.product.usecase;

import com.ecom.product.repository.ProductRepository;
import com.ecom.product.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteUseCase {

    private final ProductRepository repository;
    private final ProductValidator validator;

    public void deleteById(String id) {
        validator.validateExistsById(id);
        repository.deleteById(id);
    }
}
