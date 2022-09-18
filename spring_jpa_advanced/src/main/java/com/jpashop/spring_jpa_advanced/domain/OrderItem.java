package com.jpashop.spring_jpa_advanced.domain;

import com.jpashop.spring_jpa_advanced.domain.item.Item;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
public class OrderItem {
    private Long id;
    private Item item;
    private Order order;
    private int orderPrice;
    private int count;
}
