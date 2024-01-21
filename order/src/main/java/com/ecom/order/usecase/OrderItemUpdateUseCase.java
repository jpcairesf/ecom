package com.ecom.order.usecase;

import com.ecom.order.dto.input.OrderItemUpdateInput;
import com.ecom.order.entity.OrderItem;
import com.ecom.order.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemUpdateUseCase {

    private final OrderItemRepository repository;
    private final OrderItemReadUseCase readUseCase;

    public OrderItem update(OrderItemUpdateInput input) {
        OrderItem orderItem = readUseCase.findById(input.id());

        orderItem.setQuantity(input.quantity());
        orderItem.setPrice(input.price());
        return repository.save(orderItem);
    }

}
