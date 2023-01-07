package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 조인 전략
 * 자식이 부모 테이블의 기본 키를 받아서
 * (기본키 + 외래키) 로 사용하는 전략
 *
 * 조회할 때 조인을 자주 사용한다.
 *
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
@DiscriminatorValue("A") // 엔티티를 저장할 때 구분 컬럼에 입력할 값을 입력. DTYPE 에 값 A 가 저장된다.
public class Album extends Item {

    private String artist;

    protected Album(){}

    public Album(String artist, String name, int price) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
