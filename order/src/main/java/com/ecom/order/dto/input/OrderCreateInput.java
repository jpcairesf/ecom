package com.ecom.order.dto.input;

import java.util.List;

public record OrderCreateInput(
        String orderNumber,
        List<OrderItemCreateInput> orderItems
) { }
