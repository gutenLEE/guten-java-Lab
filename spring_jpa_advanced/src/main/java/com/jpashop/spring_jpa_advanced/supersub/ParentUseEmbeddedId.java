package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
public class ParentUseEmbeddedId {

    @EmbeddedId
    private ParentEmbeddedId id;

    private String name;


    public void setId(ParentEmbeddedId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
