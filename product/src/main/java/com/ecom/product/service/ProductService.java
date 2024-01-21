package com.ecom.product.service;

import com.ecom.product.dto.input.ProductCreateInput;
import com.ecom.product.dto.input.ProductUpdateInput;
import com.ecom.product.dto.output.ProductOutput;
import com.ecom.product.dto.mapper.ProductMapper;
import com.ecom.product.usecase.ProductCreateUseCase;
import com.ecom.product.usecase.ProductDeleteUseCase;
import com.ecom.product.usecase.ProductReadUseCase;
import com.ecom.product.usecase.ProductUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ecom.product.dto.mapper.ProductMapper.entityToOutput;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductCreateUseCase createUseCase;
    private final ProductReadUseCase readUseCase;
    private final ProductUpdateUseCase updateUseCase;
    private final ProductDeleteUseCase deleteUseCase;

    @Transactional
    public ProductOutput create(ProductCreateInput input) {
        ProductOutput output = entityToOutput(createUseCase.create(input));
        log.info("Product with ID {} created.", output.id());
        return output;
    }

    @Transactional(readOnly = true)
    public ProductOutput findByName(String name) {
        ProductOutput output = entityToOutput(readUseCase.findByName(name));
        log.info("Product with name {} found.", name);
        return output;
    }

    @Transactional(readOnly = true)
    public List<ProductOutput> findAll() {
        List<ProductOutput> output = readUseCase.findAll().stream()
                .map(ProductMapper::entityToOutput).toList();
        log.info("Found {} products.", output.size());
        return output;
    }

    @Transactional
    public ProductOutput update(ProductUpdateInput input) {
        ProductOutput output = entityToOutput(updateUseCase.update(input));
        log.info("Product with ID {} updated.", output.id());
        return output;
    }

    @Transactional
    public void deleteById(String id) {
        deleteUseCase.deleteById(id);
        log.info("Product with ID {} deleted.", id);
    }
}
