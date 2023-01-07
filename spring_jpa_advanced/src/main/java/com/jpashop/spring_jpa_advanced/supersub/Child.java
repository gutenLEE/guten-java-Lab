package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.*;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Entity
public class Child {

    @Id
    private String id;

    // 부모 테이블의 기본 키 컬럼이 복합 키이므로 자식 테이블의 외래 키도 복합 키다.
    // 따라서 외래 키 매핑 시 여러 컬럼을 패밍해야 하므로 아래 어노테이션을 사용
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1",
                referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2",
                    referencedColumnName = "PARENT_ID2"),
    })
    private Parent parent;

}
