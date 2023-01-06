package com.jpashop.spring_jpa_advanced.supersub.joinedstrategy.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

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

            // 이렇게 하면 해당 엔티티 매니저의 영속성 컨텍스트에 위에서 만든 member 객체가 저장된다.
            // 이제 member 엔티티는 엔티티 매니저의 관리 대상이 되고, 영속성을 가졌다고 말할 수 있다.
            em.persist(album);

            // 트랜잭션을 커밋한다.
            tx.commit();
        } catch(Exception e) {
            // 어떤 이유에서 오류가 났다면 트랜잭션을 롤백 시켜줘야한다.
            tx.rollback();
        } finally {
            // 엔티티 매니저를 종료시켜줘야 한다.
            // 아마 더 이상 사용하지 않는 자원이므로 더 이상 사용하지 않는 자원이라고 표시하는 것 같다.
            // 그럼 아마 GC가 해당 엔티티 매니저 자원을 수거해가서 메모리에 반환하지 않을까??
            // 성능 상 문제가 있어서 이렇게 종료시켜줘야 하는 건지 모르겠다.
            em.close();
        }

    }


}