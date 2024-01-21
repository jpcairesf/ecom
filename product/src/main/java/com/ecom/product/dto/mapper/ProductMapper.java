package com.ecom.product.dto.mapper;

import com.ecom.product.dto.output.ProductOutput;
import com.ecom.product.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static ProductOutput entityToOutput(Product product) {
        return new ProductOutput(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

}
