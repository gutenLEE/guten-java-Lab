package com.jpashop.spring_jpa_advanced.supersub.beverage;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Embeddable
public class AmericanoId implements Serializable {

    // 부모의 부모, 부모 키
    private CoffeeId coffeeId; // @MapsId("coffeeId")로 매핑

    @Column(name = "AMERICANO_ID")
    private String id;

    public AmericanoId(CoffeeId coffeeId, String id) {
        this.coffeeId = coffeeId;
        this.id = id;
    }

    protected AmericanoId() {

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmericanoId that = (AmericanoId) o;
        return Objects.equals(coffeeId, that.coffeeId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeId, id);
    }
}
