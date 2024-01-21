package com.ecom.product.exception.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductExceptionMessages {

    private static final String NOT_FOUND_BY_NAME = "Product with name \"%s\" not found.";
    private static final String NOT_FOUND_BY_ID = "Product with ID \"%s\" not found.";
    private static final String ALREADY_EXISTS_BY_NAME = "There is already a product with name \"%s\".";

    public static String notFoundByName(String name) {
        return format(NOT_FOUND_BY_NAME, name);
    }
    public static String notFoundById(String id) {
        return format(NOT_FOUND_BY_ID, id);
    }
    public static String alreadyExistsByName(String name) {
        return format(ALREADY_EXISTS_BY_NAME, name);
    }
}
