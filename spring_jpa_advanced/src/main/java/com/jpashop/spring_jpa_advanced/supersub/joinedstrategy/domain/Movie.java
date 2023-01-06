package com.jpashop.spring_jpa_advanced.supersub.joinedstrategy.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author gutenlee
 * @since 2023/01/06
 */
@Entity
@DiscriminatorValue("B")
public class Movie extends Item {

    private String director;
    private String actor;

}
