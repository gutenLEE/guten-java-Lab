package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.*;

/**
 * 조인 전략
 *
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
// 상속 매핑은 부모 클래스에 이 어노테이션을 선언해줘야 한다.
//@Inheritance(strategy = InheritanceType.JOINED) // 조인 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 구현 클래스마다 테이블 전략
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
