package com.jpashop.spring_jpa_advanced.supersub;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author gutenlee
 * @since 2023/01/07
 */
@Embeddable
public class ParentEmbeddedId implements Serializable {

    // 식별자 클래스에 기본 키를 직접 매핑한다
    @Column(name = "PATENT_ID1")
    private String id1;

    @Column(name = "PARENT_ID2")
    private String id2;

    public ParentEmbeddedId() {
    }

    public ParentEmbeddedId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentEmbeddedId that = (ParentEmbeddedId) o;
        return Objects.equals(id1, that.id1) && Objects.equals(id2, that.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }
}
