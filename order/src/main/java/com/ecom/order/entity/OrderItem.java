package com.ecom.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "ORDER_ITEM_SEQ", sequenceName = "ORDER_ITEM_SEQ")
@Table(name = "ORDER_ITEM_TABLE")
public class OrderItem {

    @Id
    @GeneratedValue(generator = "ORDER_ITEM_SEQ")
    @Column(name = "ORDER_ITEM_ID", nullable = false)
    private Long id;

    @Column(name = "SKU", nullable = false)
    private String sku;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

}
