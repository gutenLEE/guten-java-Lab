package com.jpashop.spring_jpa_advanced.domain;

import com.jpashop.spring_jpa_advanced.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
public class Category {
    private Long id;
    private String name;
    private List<Item> items = new ArrayList<>();
    private Category parent;
    private List<Category> child = new ArrayList<>();
}
