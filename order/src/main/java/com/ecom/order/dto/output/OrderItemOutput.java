package com.ecom.order.dto.output;

import java.math.BigDecimal;

public record OrderItemOutput(
        Long id,
        String sku,
        Integer quantity,
        BigDecimal price
) { }
