package com.ecom.order.usecase;

import com.ecom.order.repository.OrderRepository;
import com.ecom.order.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDeleteUseCase {

    private final OrderRepository repository;
    private final OrderValidator validator;

    public void deleteById(Long id) {
        validator.validateExistsById(id);
        repository.deleteById(id);
    }

}
