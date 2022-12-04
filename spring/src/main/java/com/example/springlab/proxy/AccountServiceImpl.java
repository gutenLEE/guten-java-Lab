package com.example.springlab.proxy;


/**
 * @author gutenlee
 * @since 2022/10/24
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        this.doSomething();
    }

    public void doSomething() {
        System.out.println("save() calls doSomething()");
    }
}
