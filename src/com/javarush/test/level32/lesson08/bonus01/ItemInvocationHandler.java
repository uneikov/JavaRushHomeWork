package com.javarush.test.level32.lesson08.bonus01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ItemInvocationHandler implements InvocationHandler {

    private Object item;

    public ItemInvocationHandler(Object item) {
        this.item = item;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===================");
        return null;
    }
}
