package com.ecom.product.validator;

import com.ecom.product.exception.EntityNotFoundException;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ecom.product.exception.messages.ProductExceptionMessages.alreadyExistsByName;
import static com.ecom.product.exception.messages.ProductExceptionMessages.notFoundById;

@Service
@RequiredArgsConstructor
public class ProductValidator {

    private final ProductRepository repository;

    public void validateExistsById(String id) {
        if(!repository.existsById(id)) throw new EntityNotFoundException(notFoundById(id));
    }

    public void validateNotExistsByName(String name) {
        if(repository.existsByName(name)) throw new BusinessException(alreadyExistsByName(name));
    }
}
