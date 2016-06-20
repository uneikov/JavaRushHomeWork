package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {
        try  // деление на 0 - №1
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // выход за пределы масива - №2
        {
            int[] arr = new int[10];
            arr[10] = 0;
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // доступ к заблокированному элементу Map -№3
        {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(1, 1); map.put(2, 2);
            for(Integer key: map.keySet()) {if(map.get(key) == 1) map.remove(key);}
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №4
        {
            FileInputStream file = new FileInputStream("");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // NullPointerException - №5
        {
            String n = null;
            System.out.println(n.equals(""));

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №6
        {
            int size = 10 - 20;
            int arr[] = new int[size];

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №7
        {
            String i = "100.00,32";
            int ii = Integer.parseInt(i);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №8
        {
            String i = "100.00,32";
            char c = i.charAt(i.length()+1);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №9
        {
            ArrayList<Integer> arr = new ArrayList<>();
            Iterator itr = arr.iterator();
            itr.remove();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try  // file not found - №10
        {
            ArrayList<Integer> arr = new ArrayList<>();
            Integer a = arr.iterator().next();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

    }
}
