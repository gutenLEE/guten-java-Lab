package com.jpashop.spring_jpa_advanced.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @author gutenlee
 * @since 2022/10/10
 */
public class ProxyTest {

    @Test
    void proxyTest() throws Exception {
        ProxyService proxyService = (ProxyService) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{ProxyService.class},
                new DynamicInvocationHandler(new ProxyServiceImpl())
        );

        System.out.println(proxyService.run("JDK Dynamic interface"));
        System.out.println(proxyService.start());
        System.out.println(proxyService.getClass());
    }


}
