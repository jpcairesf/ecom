package com.ecom.order.service;

import com.ecom.order.dto.input.OrderCreateInput;
import com.ecom.order.dto.input.OrderUpdateInput;
import com.ecom.order.dto.mapper.OrderMapper;
import com.ecom.order.dto.output.OrderOutput;
import com.ecom.order.usecase.OrderCreateUseCase;
import com.ecom.order.usecase.OrderDeleteUseCase;
import com.ecom.order.usecase.OrderReadUseCase;
import com.ecom.order.usecase.OrderUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ecom.order.dto.mapper.OrderMapper.entityToOutput;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderCreateUseCase createUseCase;
    private final OrderReadUseCase readUseCase;
    private final OrderUpdateUseCase updateUseCase;
    private final OrderDeleteUseCase deleteUseCase;

    @Transactional
    public OrderOutput create(OrderCreateInput input) {
        OrderOutput output = entityToOutput(createUseCase.create(input));
        log.info("Order created with ID {} and order number {}.", output.id(), output.orderNumber());
        return output;
    }

    @Transactional(readOnly = true)
    public OrderOutput findByOrderNumber(String orderNumber) {
        OrderOutput output = entityToOutput(readUseCase.findByOrderNumber(orderNumber));
        log.info("Order with order number {} found.", orderNumber);
        return output;
    }

    @Transactional(readOnly = true)
    public List<OrderOutput> findAllOrderByOrderNumber() {
        List<OrderOutput> output = readUseCase.findAllOrderByOrderNumber().stream()
                .map(OrderMapper::entityToOutput).toList();
        log.info("Found {} orders.", output.size());
        return output;
    }

    @Transactional
    public OrderOutput update(OrderUpdateInput input) {
        OrderOutput output = entityToOutput(updateUseCase.update(input));
        log.info("Order with ID {} updated.", input.id());
        return output;
    }

    @Transactional
    public void delete(Long id) {
        deleteUseCase.deleteById(id);
        log.info("Order with ID {} deleted.", id);
    }

}
