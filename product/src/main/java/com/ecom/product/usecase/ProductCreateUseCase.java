package com.ecom.product.usecase;

import com.ecom.product.repository.ProductRepository;
import com.ecom.product.dto.input.ProductCreateInput;
import com.ecom.product.validator.ProductValidator;
import com.ecom.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateUseCase {

    private final ProductRepository repository;
    private final ProductValidator validator;

    public Product create(ProductCreateInput input) {
        validator.validateNotExistsByName(input.name());
        
        Product product = new Product(
                input.name(),
                input.description(),
                input.price());

        return repository.save(product);
    }

}
