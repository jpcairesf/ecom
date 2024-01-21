package com.ecom.order.dto.mapper;

import com.ecom.order.dto.input.OrderItemCreateInput;
import com.ecom.order.dto.output.OrderItemOutput;
import com.ecom.order.entity.OrderItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemMapper {
    public static OrderItem inputToEntity(OrderItemCreateInput input) {
        OrderItem orderItem = new OrderItem();
        orderItem.setSku(input.sku());
        orderItem.setQuantity(input.quantity());
        orderItem.setPrice(input.price());
        return orderItem;
    }

    public static OrderItemOutput entityToOutput(OrderItem orderItem) {
        return new OrderItemOutput(
                orderItem.getId(),
                orderItem.getSku(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

}
