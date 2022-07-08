/*Пользователь вводит в консоль два числа, вывести в консоль четное число или сообщение об отсутствии такого числа.
        Время 30 минут. максимум 2 балла, после времени баллы сгорают*/


import java.util.Scanner;

public class OnlyEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int a = in.nextInt();
        System.out.println("Введите число");
        int b = in.nextInt();
        if (a % 2 == 0) System.out.println(a);
        else if (b % 2 == 0) System.out.println(b);
        else System.out.println("No Answer");
    }
}
