package com.ecom.order.dto.output;

import java.util.Set;

public record OrderOutput(
        Long id,
        String orderNumber,
        Set<OrderItemOutput> orderItems
) { }
