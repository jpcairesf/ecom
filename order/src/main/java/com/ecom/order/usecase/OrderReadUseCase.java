package com.ecom.order.usecase;

import com.ecom.order.entity.Order;
import com.ecom.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecom.order.exception.supplier.OrderExceptionSupplier.notFoundById;
import static com.ecom.order.exception.supplier.OrderExceptionSupplier.notFoundByOrderNumber;

@Service
@RequiredArgsConstructor
public class OrderReadUseCase {

    private final OrderRepository repository;

    public List<Order> findAllOrderByOrderNumber() {
        return repository.findAllOrderByOrderNumberAsc();
    }

    public Order findByOrderNumber(String orderNumber) {
        return repository.findByOrderNumber(orderNumber).orElseThrow(notFoundByOrderNumber(orderNumber));
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(notFoundById(id));
    }

}
