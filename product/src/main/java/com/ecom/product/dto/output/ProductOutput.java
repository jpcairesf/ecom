package com.ecom.product.dto.output;

import java.math.BigDecimal;

public record ProductOutput (
        String id,
        String name,
        String description,
        BigDecimal price
){ }
