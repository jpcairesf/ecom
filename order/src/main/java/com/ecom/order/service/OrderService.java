package com.ecom.order.service;

import com.ecom.order.dto.input.OrderCreateInput;
import com.ecom.order.dto.input.OrderItemCreateInput;
import com.ecom.order.dto.input.OrderUpdateInput;
import com.ecom.order.dto.mapper.OrderMapper;
import com.ecom.order.dto.output.OrderOutput;
import com.ecom.order.dto.response.InventoryResponse;
import com.ecom.order.usecase.OrderCreateUseCase;
import com.ecom.order.usecase.OrderDeleteUseCase;
import com.ecom.order.usecase.OrderReadUseCase;
import com.ecom.order.usecase.OrderStockUseCase;
import com.ecom.order.usecase.OrderUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilderFactory;

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
    private final OrderStockUseCase stockUseCase;
    private final WebClient.Builder webClientBuilder;

    @Transactional
    public OrderOutput create(OrderCreateInput input) {
        List<String> skuList = input.orderItems().stream().map(OrderItemCreateInput::sku).toList();
        InventoryResponse[] responseArray = webClientBuilder.build().get()
                .uri("https://inventory/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("sku", skuList).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        stockUseCase.checkInStock(responseArray);

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
    public List<OrderOutput> findAll() {
        List<OrderOutput> output = readUseCase.findAll().stream()
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
