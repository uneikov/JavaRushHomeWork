package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<>();

        Cat cat1 = new Cat(); result.add(cat1);
        Cat cat2 = new Cat(); result.add(cat2);
        Cat cat3 = new Cat(); result.add(cat3);
        Cat cat4 = new Cat(); result.add(cat4);

        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> result = new HashSet<>();

        Dog dog1 = new Dog(); result.add(dog1);
        Dog dog2 = new Dog(); result.add(dog2);
        Dog dog3 = new Dog(); result.add(dog3);

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        HashSet<Object> result = new HashSet<>();
        for (Cat element : cats)result.add(element);
        for (Dog element : dogs)result.add(element);
        /*Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext())
        {
            Cat currentCat = (iterator.next());
            result.add(currentCat);
        }
        Iterator<Dog> diterator = dogs.iterator();
        while (diterator.hasNext())
        {
            Dog currentDog = (diterator.next());
            result.add(currentDog);
        }
        */
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Set<Object> copyPets = new HashSet<>(pets);
        Iterator<Cat> citerator = cats.iterator();

        while (citerator.hasNext())
        {
            Cat currentCat = citerator.next();
            Iterator<Object> piterator = copyPets.iterator();
            while (piterator.hasNext())
            {
                Object currentPet = piterator.next();
                if (currentPet.equals(currentCat)) pets.remove(currentPet);
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object element : pets) System.out.println(element);
        /*Iterator<Object> iterator = pets.iterator();

        while (iterator.hasNext())
       {
            Object currentPet = iterator.next();
            System.out.println(currentPet);
        }
        */
    }

    public static class Cat{}
    public static class Dog{}

}
