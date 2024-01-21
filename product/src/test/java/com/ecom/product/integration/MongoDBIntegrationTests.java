package com.ecom.product.integration;

import com.ecom.product.repository.ProductRepository;
import com.ecom.product.dto.input.ProductCreateInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc(addFilters = false)
class MongoDBIntegrationTests {

    static final String ENDPOINT = "/api/product";
    final ObjectMapper objectMapper = new ObjectMapper();

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0.5"));

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository repository;

    @Test
    void shouldCreateProduct() throws Exception {
        mongoDBContainer.start();
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(getCreateInput())))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, repository.findAll().size());
        mongoDBContainer.close();
    }

    private ProductCreateInput getCreateInput() {
        return new ProductCreateInput(
                "Testcontainer Product",
                "Test product",
                new BigDecimal(10)
        );
    }

}
