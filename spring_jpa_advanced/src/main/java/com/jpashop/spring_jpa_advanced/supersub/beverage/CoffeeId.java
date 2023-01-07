package com.jpashop.spring_jpa_advanced.supersub.beverage;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Embeddable
public class CoffeeId implements Serializable {

    private String beverageId; // @MapsId("beverageId")로 매핑

    @Column(name = "COFFEE_ID")
    private String id;

    public CoffeeId(String beverageId, String id) {
        this.beverageId = beverageId;
        this.id = id;
    }

    protected CoffeeId() {
    }
}
