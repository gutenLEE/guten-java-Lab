package com.jpashop.spring_jpa_advanced.supersub.car;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
@IdClass(SuvId.class)
public class Suv {

    @Id // 기본키를 매핑하면서
    // 외래 키를 같이 매핑한다
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    public Car car;

    @Id @Column(name = "SUV_ID")
    private String childId;

    private String name;

    protected Suv(){}

    public Suv(Car car, String childId, String name) {
        this.car = car;
        this.childId = childId;
        this.name = name;
    }
}
