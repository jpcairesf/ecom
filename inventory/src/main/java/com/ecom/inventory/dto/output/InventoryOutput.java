package com.ecom.inventory.dto.output;

public record InventoryOutput(
        String id,
        String sku,
        Integer quantity
) { }
