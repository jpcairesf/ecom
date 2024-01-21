package com.ecom.order.dto.input;

import java.math.BigDecimal;

public record OrderItemCreateInput(
    String sku,
    Integer quantity,
    BigDecimal price
) { }
