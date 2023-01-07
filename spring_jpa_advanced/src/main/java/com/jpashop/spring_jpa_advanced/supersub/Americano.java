package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
public class Americano {

    @EmbeddedId
    private AmericanoId americanoId;

    @MapsId("coffeeId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "BEVERAGE_ID"),
            @JoinColumn(name = "COFFEE_ID")
    })
    private Coffee coffee;

    private String name;


}
