package com.ecom.order.usecase;

import com.ecom.order.entity.OrderItem;
import com.ecom.order.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ecom.order.exception.supplier.OrderExceptionSupplier.notFoundById;

@Service
@RequiredArgsConstructor
public class OrderItemReadUseCase {

    private final OrderItemRepository repository;

    public OrderItem findById(Long id) {
        return repository.findById(id).orElseThrow(notFoundById(id));
    }

}
