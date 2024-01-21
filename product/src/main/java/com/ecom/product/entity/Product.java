package com.ecom.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value = "product")
public class Product {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String name;

    @NonNull
    private String description;

    @NonNull
    private BigDecimal price;

}
