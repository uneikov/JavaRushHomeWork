package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        byte next = 0;
        ByteArrayOutputStream baos = null;
        boolean digit = false, lower = false, upper = false;

        while (true) {

            baos = new ByteArrayOutputStream();
            digit = lower = upper = false;

            for (int i = 0; i < 8; i++) {

                int choice = new Random().nextInt(3);

                switch (choice) {
                    case 0:
                        next = (byte) (48 + new Random().nextInt(9));
                        digit = true;
                        break;
                    case 1:
                        next = (byte) (65 + new Random().nextInt(25));
                        upper = true;
                        break;
                    case 2:
                        next = (byte) (97 + new Random().nextInt(25));
                        lower = true;
                        break;
                }
                baos.write(next);
            }
            if (digit && lower && upper) break;
        }

        return baos;
    }
}
