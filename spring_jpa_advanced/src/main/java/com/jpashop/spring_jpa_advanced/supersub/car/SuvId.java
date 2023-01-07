package com.jpashop.spring_jpa_advanced.supersub.car;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
public class SuvId implements Serializable {


    private String car; // Suv.parent 매핑
    private String childId; // Suv.childId 매핑

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuvId suvId = (SuvId) o;
        return Objects.equals(car, suvId.car) && Objects.equals(childId, suvId.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, childId);
    }
}
