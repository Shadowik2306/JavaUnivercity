import java.util.Scanner;

public class RepeatsCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int num = in.nextInt();
        num = (int)Math.pow(num, num);
        int[] answer = new int[] {0,0,0,0,0,0,0,0,0,0};

        while (num >= 10) {
            answer[num % 10]++;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + answer[i]);
        }
    }
}
