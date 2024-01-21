package com.ecom.order.dto.input;

import java.math.BigDecimal;

public record OrderItemUpdateInput(
    Long id,
    Integer quantity,
    BigDecimal price
) { }
