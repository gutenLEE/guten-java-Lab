package com.example.springlab;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author gutenlee
 * @since 2022/06/30
 */

@SpringBootTest
public class BeanTest {

    ObjectMapper ob = new ObjectMapper();

    @Test
    void search_bean_test() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        Map<String, Encoder> beansOfType = applicationContext.getBeansOfType(Encoder.class);
        System.out.println("beansOfType = " + beansOfType);

    }


}
