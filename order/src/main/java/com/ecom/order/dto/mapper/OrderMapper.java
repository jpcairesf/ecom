package com.ecom.order.dto.mapper;

import com.ecom.order.dto.output.OrderItemOutput;
import com.ecom.order.dto.output.OrderOutput;
import com.ecom.order.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderOutput entityToOutput(Order order) {
        Set<OrderItemOutput> orderItems = order.getOrderItems().stream()
                .map(OrderItemMapper::entityToOutput)
                .collect(Collectors.toSet());

        return new OrderOutput(
                order.getId(),
                order.getOrderNumber(),
                orderItems
        );
    }

}
