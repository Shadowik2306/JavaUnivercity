/*Дано целое число, лежащее в диапазоне от -999 до 999. Вывести строку — словесное описание данного
        числа вида "отрицательное двузначное число", "нулевое число", "положительное однозначное число" и т.д.
        Правила те же*/

/*Релизация через if, была сдана с помощью switch case*/

import java.util.Scanner;

public class StringNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int num = in.nextInt();
        String answer = "";

        if (num != 0) {
            if (num > 0) {
                answer = answer + "Положительное ";
            }
            else {
                answer = answer + "Отрицательное ";
            }
            num = Math.abs(num);
            if (num < 10) answer = answer + "однозначное ";
            else if (num < 100) answer = answer + "двузначное ";
            else answer = answer + "трехзначное ";
            answer = answer + "число";
        }
        else answer = "Нулевое число";

        System.out.println(answer);
    }
}
