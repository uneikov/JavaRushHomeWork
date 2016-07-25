package com.javarush.test.level32.lesson08.bonus01;


import java.lang.reflect.Proxy;

/* Дженерики для создания прокси-объекта
В классе Solution создайте публичный метод getProxy
1) Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item
2) getProxy должен иметь два параметра. Первый - класс возвращаемого типа, второй - классы дополнительных интерфейсов.
3) Используйте ItemInvocationHandler для создания прокси
Метод main не участвует в тестировании
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //test(solution.getProxy(Item.class));                        //true false false
        //test(solution.getProxy(Item.class, Small.class));           //true false true
        //test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }

    public <T extends Class> Object getProxy(T... args){

        Object result = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].getClass().isInstance(Item.class)){
                ClassLoader cl = args[i].getClassLoader();
                Class[] interfaces = args[i].getInterfaces();
                ItemInvocationHandler handler = new ItemInvocationHandler(args[i]);
                result = Proxy.newProxyInstance(
                        cl,
                        interfaces,
                        handler
                );

                break;
            }
        }

        //Class<T>[] in = new Class[] {returnClass};
        //ClassLoader classLoader = returnClass.getClassLoader();
        //Class[] intfac = returnClass.getInterfaces();

        //Class<T>[] inc = new Class[] {comlementClass[0]};
        //ClassLoader classLoader1 = comlementClass[0].getClassLoader();
        //Class[] intfac1 = comlementClass[0].getInterfaces();
/*
        if (args[0.length == 0){
            result = (Item)Proxy.newProxyInstance(
                    returnClass.getClass().getClassLoader(),
                    //new Class[] {returnClass},
                    returnClass.getClass().getInterfaces(),
                    new ItemInvocationHandler(returnClass)
            );

        }else {

            for (int i = 0; i < comlementClass.length; i++) {
                if (comlementClass[i].getClass().isInstance(returnClass.getClass())) {
                    result = Proxy.newProxyInstance(
                            comlementClass[i].getClass().getClassLoader(),
                            comlementClass[i].getClass().getInterfaces(),
                            //new Class[] {comlementClass[i]},
                            new ItemInvocationHandler(comlementClass[i])
                    );
                }
            }
        }
*/
        return result;
    }
}
