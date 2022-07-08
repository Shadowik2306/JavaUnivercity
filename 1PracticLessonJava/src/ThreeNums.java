/*Пользователь вводит в консоль три числа (максимум 5 разрядов). Определить, делится ли сумма первых двух на сумму
        цифр третьего, и вывести об этом сообщение в консоль. Работу со строками не использовать.
        Время час. максимум 4 балла*/

import java.util.Scanner;

public class ThreeNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int a = in.nextInt();
        System.out.println("Введите число");
        int b = in.nextInt();
        System.out.println("Введите число");
        int c = in.nextInt();

        int up = a + b, down = 0;
        while (c >= 10) {
            down += c % 10;
            c /= 10;
        }
        down += c;
        if (up % down == 0) System.out.println("Делится");
        else System.out.println("Не делиться");
    }
}
