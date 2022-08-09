package com.example.springlab;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gutenlee
 * @since 2022/08/08
 */
@Component
@Data
public class PropertySource {

    @Value("${db.host}")
    private String host;
    @Value("${db.port}")
    private int port;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.uri-with-quotes}")
    private String uriWithQuotes;
}
