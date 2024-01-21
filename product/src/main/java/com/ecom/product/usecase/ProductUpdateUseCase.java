package com.ecom.product.usecase;

import com.ecom.product.repository.ProductRepository;
import com.ecom.product.dto.input.ProductUpdateInput;
import com.ecom.product.validator.ProductValidator;
import com.ecom.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateUseCase {

    private final ProductRepository repository;
    private final ProductReadUseCase readUseCase;
    private final ProductValidator validator;

    public Product update(ProductUpdateInput input) {
        Product product = readUseCase.findById(input.id());

        if(!product.getName().equalsIgnoreCase(input.name())) {
            validator.validateNotExistsByName(input.name());
            product.setName(input.name());
        }


        product.setDescription(input.description());
        product.setPrice(input.price());
        return repository.save(product);
    }
}
