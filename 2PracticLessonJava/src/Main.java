import java.io.PrintStream;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        chooseTypeList();
    }

    public static void chooseTypeList() {
        System.out.println("Выберите тип:  (Введите число)");
        System.out.println("1) Одномерный");
        System.out.println("2) Двумерный");
        String str = in.nextLine();
        while (true) {
            if (Objects.equals(str, "1")) {
                new MyList();
                break;
            }
            else if (Objects.equals(str, "2")) {
                new MyDoubleList();
                break;
            }
            else {
                System.out.println("Ошибка. Непонятный ввод");
                System.exit(0);
            }

        }
    }
}
