package com.jpashop.spring_jpa_advanced.supersub.car;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
@IdClass(GenesisGV80Id.class)
public class GenesisGV80 {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CAR_ID"),
            @JoinColumn(name = "SUV_ID")
    })
    private Suv suv;

    @Id @Column(name = "GenesisGV80_ID")
    private String genesisId;

    private String name;

    protected GenesisGV80(){}

    public GenesisGV80(Suv suv, String genesisId, String name) {
        this.suv = suv;
        this.genesisId = genesisId;
        this.name = name;
    }
}
