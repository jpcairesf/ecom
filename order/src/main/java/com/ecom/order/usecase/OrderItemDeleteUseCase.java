package com.ecom.order.usecase;

import com.ecom.order.repository.OrderItemRepository;
import com.ecom.order.validator.OrderItemValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemDeleteUseCase {

    private final OrderItemRepository repository;
    private final OrderItemValidator validator;

    public void deleteById(Long id) {
        validator.validateExistsById(id);
        repository.deleteById(id);
    }

}
