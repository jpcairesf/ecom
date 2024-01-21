package com.ecom.order.usecase;

import com.ecom.order.dto.input.OrderCreateInput;
import com.ecom.order.dto.mapper.OrderItemMapper;
import com.ecom.order.entity.Order;
import com.ecom.order.entity.OrderItem;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderCreateUseCase {

    private final OrderRepository repository;
    private final OrderValidator validator;

    public Order create(OrderCreateInput input) {
        validator.validateNotExistsByOrderNumber(input.orderNumber());

        Set<OrderItem> orderItems = input.orderItems().stream()
                .map(OrderItemMapper::inputToEntity)
                .collect(Collectors.toSet());

        Order order = new Order();
        order.setOrderNumber(input.orderNumber());
        order.setOrderItems(orderItems);

        return repository.save(order);
    }

}
