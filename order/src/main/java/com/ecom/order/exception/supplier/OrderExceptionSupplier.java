package com.ecom.order.exception.supplier;

import com.ecom.order.exception.message.OrderExceptionMessage;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderExceptionSupplier {

    public static Supplier<EntityNotFoundException> notFoundById(Long id) {
        return () -> new EntityNotFoundException(OrderExceptionMessage.notFoundById(id));
    }

    public static Supplier<EntityNotFoundException> notFoundByOrderNumber(String orderNumber) {
        return () -> new EntityNotFoundException(OrderExceptionMessage.notFoundByOrderNumber(orderNumber));
    }

}
