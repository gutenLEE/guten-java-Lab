package com.jpashop.spring_jpa_advanced.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author gutenlee
 * @since 2022/10/10
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();
    private final Object target;

    public DynamicInvocationHandler(final Object target) {
        this.target = target;
        for (Method declaredMethod : target.getClass().getDeclaredMethods()) {
            this.methods.put(declaredMethod.getName(), declaredMethod);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Dynamic proxy 적용 메서드");
        return methods.get(method.getName()).invoke(target, args);
    }
}
