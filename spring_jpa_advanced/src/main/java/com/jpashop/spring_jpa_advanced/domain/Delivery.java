package com.jpashop.spring_jpa_advanced.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2022/09/18
 */
@Entity
public class Delivery {
    @Id
    private Long deliveryId;
}
