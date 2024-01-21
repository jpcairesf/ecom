package com.ecom.product.dto.input;

import java.math.BigDecimal;

public record ProductUpdateInput(
        String id,
        String name,
        String description,
        BigDecimal price
) { }
