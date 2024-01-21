package com.ecom.order.exception.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemExceptionMessage {

    private static final String NOT_FOUND_BY_ID = "Order item with ID \"%s\" not found.";

    public static String notFoundById(Long id) {
        return format(NOT_FOUND_BY_ID, id);
    }

}
