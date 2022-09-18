package com.jpashop.spring_jpa_advanced.domain.item;


import com.jpashop.spring_jpa_advanced.domain.Category;

import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
public abstract class Item {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private List<Category> categories;
}
