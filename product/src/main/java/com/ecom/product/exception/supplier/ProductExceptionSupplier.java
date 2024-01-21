package com.ecom.product.exception.supplier;

import com.ecom.product.exception.messages.ProductExceptionMessages;
import com.ecom.product.exception.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductExceptionSupplier {

    public static Supplier<EntityNotFoundException> notFoundByName(String name) {
        return () -> new EntityNotFoundException(ProductExceptionMessages.notFoundByName(name));
    }

    public static Supplier<EntityNotFoundException> notFoundById(String id) {
        return () -> new EntityNotFoundException(ProductExceptionMessages.notFoundById(id));
    }

}
