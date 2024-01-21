package com.ecom.order.service;

import com.ecom.order.dto.input.OrderItemUpdateInput;
import com.ecom.order.dto.output.OrderItemOutput;
import com.ecom.order.usecase.OrderItemDeleteUseCase;
import com.ecom.order.usecase.OrderItemReadUseCase;
import com.ecom.order.usecase.OrderItemUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ecom.order.dto.mapper.OrderItemMapper.entityToOutput;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemService {

    private final OrderItemReadUseCase readUseCase;
    private final OrderItemUpdateUseCase updateUseCase;
    private final OrderItemDeleteUseCase deleteUseCase;

    @Transactional(readOnly = true)
    public OrderItemOutput findById(Long id) {
        OrderItemOutput output = entityToOutput(readUseCase.findById(id));
        log.info("Order item with ID {} found.", id);
        return output;
    }

    @Transactional
    public OrderItemOutput update(OrderItemUpdateInput input) {
        OrderItemOutput output = entityToOutput(updateUseCase.update(input));
        log.info("Order item with ID {} updated.", input);
        return output;
    }

    @Transactional
    public void deleteById(Long id) {
        deleteUseCase.deleteById(id);
        log.info("Order item with ID {} deleted.", id);
    }

}
