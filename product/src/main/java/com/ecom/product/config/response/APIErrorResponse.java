package com.ecom.product.config.response;

import java.time.LocalDate;

public record APIErrorResponse(
    String message,
    int code,
    String status,
    LocalDate timestamp,
    String description
) { }
