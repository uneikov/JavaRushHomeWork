package com.javarush.test.level13.lesson11.home07;

/* Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    static class StringObject<T> implements SimpleObject<String> // Указать явно тип параметра
    {
        public SimpleObject<String> getInstance() // Указать явно тип параметра (то же самое)
        {
            return new StringObject<>();
        }
    }
}


