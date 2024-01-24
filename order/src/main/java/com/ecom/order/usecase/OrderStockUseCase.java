package com.ecom.order.usecase;

import com.ecom.order.dto.response.InventoryResponse;
import com.ecom.order.exception.BusinessException;
import com.ecom.order.exception.message.OrderExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderStockUseCase {


    public void checkInStock(InventoryResponse[] responseArray) {
        boolean anyOutOfStock = Arrays.stream(responseArray).anyMatch(i -> i.quantity() == 0);
        if(anyOutOfStock) {
            String sku = Arrays.stream(responseArray)
                    .filter(i -> i.quantity() == 0)
                    .map(InventoryResponse::sku)
                    .collect(Collectors.joining(", "));

            throw new BusinessException(OrderExceptionMessage.followingSkuNotInStock(sku));
        }
    }
}
