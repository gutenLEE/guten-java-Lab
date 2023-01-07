package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
@IdClass(ParentId.class)
public class Parent {

    @Id
    @Column(name = "PARENT_ID1")
    private String id1;

    @Id
    @Column(name = "PARENT_ID2")
    private String id2;

    private String name;

    protected Parent(){}

    public Parent(String id1, String id2, String name) {
        this.id1 = id1;
        this.id2 = id2;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
