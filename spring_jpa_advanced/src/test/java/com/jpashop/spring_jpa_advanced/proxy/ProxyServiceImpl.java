package com.jpashop.spring_jpa_advanced.proxy;

/**
 * @author gutenlee
 * @since 2022/10/10
 */
public class ProxyServiceImpl implements ProxyService {
    @Override
    public String run(String msg) {
        return "hello world";
    }

    @Override
    public String start() {
        return "start";
    }
}
