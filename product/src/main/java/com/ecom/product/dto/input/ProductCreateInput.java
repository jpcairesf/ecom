package com.ecom.product.dto.input;

import java.math.BigDecimal;

public record ProductCreateInput(
        String name,
        String description,
        BigDecimal price
) { }
