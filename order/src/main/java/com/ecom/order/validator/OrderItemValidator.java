package com.ecom.order.validator;

import com.ecom.order.repository.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ecom.order.exception.message.OrderExceptionMessage.notFoundById;

@Service
@RequiredArgsConstructor
public class OrderItemValidator {

    private final OrderItemRepository repository;

    public void validateExistsById(Long id) {
        if(!repository.existsById(id)) throw new EntityNotFoundException(notFoundById(id));
    }

}
