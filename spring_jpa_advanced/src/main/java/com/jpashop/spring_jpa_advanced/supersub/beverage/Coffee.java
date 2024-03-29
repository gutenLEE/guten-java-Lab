package com.jpashop.spring_jpa_advanced.supersub.beverage;

import com.jpashop.spring_jpa_advanced.supersub.beverage.Beverage;
import com.jpashop.spring_jpa_advanced.supersub.beverage.CoffeeId;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2023/01/07
 */

// 자식
@Entity
public class Coffee {

    @EmbeddedId
    private CoffeeId coffeeId;

    @MapsId("beverageId")
    @ManyToOne
    @JoinColumn(name = "BEVERAGE_ID")
    public Beverage beverage;

}
