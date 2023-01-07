package com.jpashop.spring_jpa_advanced.supersub.joinedstrategy.domain;

import com.jpashop.spring_jpa_advanced.supersub.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;


@DataJpaTest
class ItemTest {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    void create() throws Exception {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 엔티티 매니저에서 수행하는 모든 로직은 트랜잭선 안에서 수행돼야 한다.
            tx.begin();

            Album album = new Album("BTS", "RUN", 32_000);

            em.persist(album);
            tx.commit();


        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }


}