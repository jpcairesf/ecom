package com.ecom.inventory.dto.input;

public record InventoryCreateInput(
        String sku,
        Integer quantity
) { }
