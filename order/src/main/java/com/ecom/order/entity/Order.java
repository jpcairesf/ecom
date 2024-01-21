package com.ecom.order.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ")
@Table(name = "ORDER", uniqueConstraints = {
    @UniqueConstraint(name = "UQ_ORDER_NUMBER", columnNames = "ORDER_NUMBER")})
public class Order {

    @Id
    @GeneratedValue(generator = "ORDER_SEQ")
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

    @Column(name = "ORDER_NUMBER", nullable = false)
    private String orderNumber;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

}
