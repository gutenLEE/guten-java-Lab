package com.jpashop.spring_jpa_advanced.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
public class Order {
    private Long id;
    private Member member;
    private List<OrderItem> orderItems;
    private Delivery delivery;
    private LocalDateTime orderDate;
    private OrderStatus status;
}
