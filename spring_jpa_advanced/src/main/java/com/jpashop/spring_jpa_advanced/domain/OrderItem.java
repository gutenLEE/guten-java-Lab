package com.jpashop.spring_jpa_advanced.domain;

import com.jpashop.spring_jpa_advanced.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item; //주문 상품
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; //주문
    private int orderPrice; //주문 가격
    private int count; //주문 수량
}