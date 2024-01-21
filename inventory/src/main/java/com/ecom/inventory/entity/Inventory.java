package com.ecom.inventory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value = "inventory")
public class Inventory {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String sku;

    @NonNull
    private Integer quantity;

}
