package chap4;

import org.junit.jupiter.api.*;

/**
 * @author gutenlee
 * @since 2022/05/21
 */
public class LifeCycleTest {

    public LifeCycleTest() {
        System.out.println("new LifeCycleTest");
    }

    @BeforeEach
    void beforeAll() {
        System.out.println("set up");
    }

    @Test
    void a() {
        System.out.println("test a");
    }

    @Test
    void b() throws Exception {
        System.out.println("test b");
    }

    @AfterEach
    void afterAll() {
        System.out.println("tear down");
    }
}
