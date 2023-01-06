package com.jpashop.spring_jpa_advanced.supersub.joinedstrategy.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
@DiscriminatorValue("B")
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
