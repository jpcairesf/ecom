package com.ecom.inventory.exception.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryExceptionMessages {

    private static final String NOT_FOUND_BY_SKU = "Inventory with sku \"%s\" not found.";
    private static final String ALREADY_EXISTS_BY_SKU = "There is already an inventory with sku \"%s\".";
    private static final String NOT_IN_STOCK_BY_SKU = "There is no available stock in the inventory with sku \"%s\".";
    private static final String NOT_FOUND_ALL_BY_SKU_IN = "Not all the inventories were found in the given sku list.";

    public static String notFoundBySku(String sku) {
        return format(NOT_FOUND_BY_SKU, sku);
    }

    public static String alreadyExistsBySku(String sku) {
        return format(ALREADY_EXISTS_BY_SKU, sku);
    }

    public static String notInStockBySku(String sku) {
        return format(NOT_IN_STOCK_BY_SKU, sku);
    }

    public static String notFoundAllBySkuIn() {
        return NOT_FOUND_ALL_BY_SKU_IN;
    }
}
