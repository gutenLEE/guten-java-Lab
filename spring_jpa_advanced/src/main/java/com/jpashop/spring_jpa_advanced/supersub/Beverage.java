package com.jpashop.spring_jpa_advanced.supersub;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2023/01/07
 */

// 부모
@Entity
public class Beverage {

    @Id @Column(name = "BEVERAGE_ID")
    private String id;

    private String name;
}
