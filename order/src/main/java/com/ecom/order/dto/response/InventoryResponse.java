package com.ecom.order.dto.response;

public record InventoryResponse(
        String id,
        String sku,
        Integer quantity
) { }
