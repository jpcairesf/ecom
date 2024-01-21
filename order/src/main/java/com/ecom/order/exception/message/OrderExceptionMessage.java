package com.ecom.order.exception.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderExceptionMessage {

    private static final String ALREADY_EXISTS_BY_ORDER_NUMBER = "There is already an order with order number \"%s\".";
    private static final String NOT_FOUND_BY_ID = "Order with ID \"%s\" not found.";
    private static final String NOT_FOUND_BY_ORDER_NUMBER = "Order with order number \"%s\" not found.";

    public static String alreadyExistsByOrderNumber(String orderNumber) {
        return format(ALREADY_EXISTS_BY_ORDER_NUMBER, orderNumber);
    }

    public static String notFoundById(Long id) {
        return format(NOT_FOUND_BY_ID, id);
    }

    public static String notFoundByOrderNumber(String orderNumber) {
        return format(NOT_FOUND_BY_ORDER_NUMBER, orderNumber);
    }
}
