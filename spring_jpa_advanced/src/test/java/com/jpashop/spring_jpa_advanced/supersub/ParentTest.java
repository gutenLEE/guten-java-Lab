package com.jpashop.spring_jpa_advanced.supersub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.*;

@DataJpaTest
class ParentTest {
    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    void idClassTest() throws Exception {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 엔티티 매니저에서 수행하는 모든 로직은 트랜잭선 안에서 수행돼야 한다.
            tx.begin();

            Parent parent = new Parent("id1", "id2", "Max");
            em.persist(parent);

            Parent findParent = em.find(Parent.class, new ParentId("id1", "id2"));

            System.out.println("findParent = " + findParent);

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Test
    void embeddedIdTest() throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 엔티티 매니저에서 수행하는 모든 로직은 트랜잭선 안에서 수행돼야 한다.
            tx.begin();
            // 식별자 클래스를 직접 생성해서 사용한다.
            ParentEmbeddedId embeddedId = new ParentEmbeddedId("ID1", "ID2");
            ParentUseEmbeddedId parent = new ParentUseEmbeddedId();
            parent.setId(embeddedId);
            parent.setName("PARK");
            em.persist(parent);

            ParentUseEmbeddedId parentUseEmbeddedId = em.find(ParentUseEmbeddedId.class, embeddedId);
            System.out.println("parentUseEmbeddedId = " + parentUseEmbeddedId);

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }


    @Test
    @DisplayName("복합 키: 식별 관계 매핑")
    void compositeKeyMappingTest() throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 엔티티 매니저에서 수행하는 모든 로직은 트랜잭선 안에서 수행돼야 한다.
            tx.begin();

            Car car = new Car("car id 1", "자동차");
            Suv suv = new Suv(car, "suv id 1", "SUV");
            GenesisGV80 gv80 = new GenesisGV80(suv, "GV80 id 1", "GV80");

            em.persist(gv80);

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }


}