package com.jpashop.spring_jpa_advanced.supersub.joinedstrategy.domain;

import javax.persistence.*;

/**
 * 조인 전략
 *
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 상속 매핑은 부모 클래스에 이 어노테이션을 선언해줘야 한다.
@DiscriminatorColumn(name = "DTYPE") // 부모클래스에 구분 컬럼 지정. 이 컬럼으로 자식 테이블 구분 가능
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;

    public Item(){}

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
