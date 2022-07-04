package com.example.springlab;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author gutenlee
 * @since 2022/06/30
 */
@FeignClient(name = "test-service")
public interface FeignTestClient {
    @GetMapping("/search")
    void test();
}
