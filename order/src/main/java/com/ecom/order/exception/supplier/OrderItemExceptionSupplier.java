package com.ecom.order.exception.supplier;

import com.ecom.order.exception.message.OrderItemExceptionMessage;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemExceptionSupplier {

    public static Supplier<EntityNotFoundException> notFoundById(Long id) {
        return () -> new EntityNotFoundException(OrderItemExceptionMessage.notFoundById(id));
    }

}
