package com.ecom.order.validator;

import com.ecom.order.exception.BusinessException;
import com.ecom.order.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ecom.order.exception.message.OrderExceptionMessage.alreadyExistsByOrderNumber;
import static com.ecom.order.exception.message.OrderExceptionMessage.notFoundById;

@Service
@RequiredArgsConstructor
public class OrderValidator {

    private final OrderRepository repository;

    public void validateNotExistsByOrderNumber(String orderNumber) {
        if(repository.existsByOrderNumber(orderNumber))
            throw new BusinessException(alreadyExistsByOrderNumber(orderNumber));
    }

    public void validateExistsById(Long id) {
        if(!repository.existsById(id)) throw new EntityNotFoundException(notFoundById(id));
    }
}
