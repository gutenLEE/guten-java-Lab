package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
@DiscriminatorValue("BOOK") // 지정하지 않으면 기본으로 엔티티 이름을 사용
@PrimaryKeyJoinColumn(name = "BOOK_ID") // ID 재정의
public class Book extends Item {

    private String author;
    private String isbn;

    protected Book(){}

    public Book(String author, String name, int price) {
        super(name, price);
        this.author = author;
    }
}
