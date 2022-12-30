package com.example.springlab.mysqls;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(properties = "eureka.client.enabled=false")
class TransactionTest {

    public static final MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:8");

    @Autowired
    private BoardRepository boardRepository;

    @Before
    public void setUp() {
        MYSQL_CONTAINER.withDatabaseName("sql_study")
                .withUsername("gutenlee")
                .withPassword("1234");
    }

    @Test
    void log() throws Exception {
        Board save = boardRepository.save(new Board(1));
        System.out.println("save = " + save);
    }


}