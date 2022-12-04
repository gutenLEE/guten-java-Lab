package com.example.springlab.proxy;

import org.aopalliance.aop.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;


class AccountServiceImplTest {

    @Test
    void direct_call() throws Exception {
        AccountService accountService = new AccountServiceImpl();
        accountService.save();
    }

    @Test
    void proxy_call() throws Exception {


    }



}