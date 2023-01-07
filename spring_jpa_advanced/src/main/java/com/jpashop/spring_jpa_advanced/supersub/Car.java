package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
public class Car {

    @Id
    @Column(name = "CAR_ID")
    private String id;

    private String name;

    protected Car(){}

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
