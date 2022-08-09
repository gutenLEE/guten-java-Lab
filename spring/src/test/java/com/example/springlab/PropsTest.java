package com.example.springlab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/08/08
 */


@ActiveProfiles("ops")
@SpringBootTest(properties = "eureka.client.enabled=false")
public class PropsTest {

    @Autowired
    private PropertySource propertySource;

    @Test
    void get_value_from_props_file_test() throws Exception {
         assertThat(propertySource.getHost()).isEqualTo("test");
    }

    @Test
    void get_value_from_props_with_comma() throws Exception {
         assertThat(propertySource.getUri()).isEqualTo("localhost,localhost2");
         assertThat(propertySource.getUriWithQuotes()).isEqualTo("localhost,localhost2");
    }


}
