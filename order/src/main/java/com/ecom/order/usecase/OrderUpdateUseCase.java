package com.ecom.order.usecase;

import com.ecom.order.dto.input.OrderUpdateInput;
import com.ecom.order.entity.Order;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderUpdateUseCase {

    private final OrderRepository repository;
    private final OrderReadUseCase readUseCase;
    private final OrderValidator validator;

    public Order update(OrderUpdateInput input) {
        Order order = readUseCase.findById(input.id());

        if(!order.getOrderNumber().equalsIgnoreCase(input.orderNumber())) {
            validator.validateNotExistsByOrderNumber(input.orderNumber());
            order.setOrderNumber(input.orderNumber());
        }

        return repository.save(order);
    }

}
