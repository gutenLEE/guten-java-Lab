package com.jpashop.spring_jpa_advanced.domain;

import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
public class Member {
    private Long id;
    private String name;
    private Address address;
    private List<Order> orders = new ArrayList<>();
}
