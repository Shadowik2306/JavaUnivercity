import java.util.*;


public class MyList {
    static Scanner in = new Scanner(System.in);

    public MyList() {
        System.out.println("Выберите тип заполнения:  (Введите число)");
        System.out.println("1) Случайный");
        System.out.println("2) Вручную");
        while (true) {
            String str = in.nextLine();
            if (Objects.equals(str, "1")) {
                randomIn();
                break;
            }
            else if (Objects.equals(str, "2")) {
                specialIn();
                break;
            }
            else {
                System.out.println("Ошибка. Непонятный ввод");
                System.exit(0);
            }
        }
    }

    public void randomIn() {
        System.out.println("Введите сколько элементов");
        int range = 0;
        try {
            range = in.nextInt();
        } catch (Exception e) {
            System.out.println("Error, не число");
            System.exit(0);
        }


        int[] arr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round((Math.random() * 30) - 15);
        }
        printListNotLastDivided(arr);
    }


    public void specialIn() {
        System.out.println("Введите сколько элементов");
        int range = 0;
        try {
            range = in.nextInt();
        } catch (Exception e) {
            System.out.println("Error, не число");
            System.exit(0);
        }


        System.out.println("Введите элементы");
        int[] arr = new int[range];
        int a;
        while (range > 0) {
            while (true) {
                try {
                    a = in.nextInt();
                    arr[arr.length - range] = a;
                    range--;
                    break;
                } catch (Exception e) {
                    System.out.println("Error, не число");
                    System.exit(0);
                }
            }
        }
        printListNotLastDivided(arr);
    }


    public void printNotPairsList(int[] arr) {
        System.out.println("Ваш массив");
        int[] buffArr = arr.clone();
        int[] itWas = new int[arr.length];
        int pos = 0;

        int k = 0;
        for (int j : arr) {
            k = 0;
            for (int itemB : buffArr) {
                if (itemB == j) k++;
            }
            if (k == 2 || k == 3) {
                itWas[pos] = j;
                pos++;
            }
        }

        boolean found;
        int third_cup, redacted = pos;
        for (int i = 0; i < arr.length - 1; i++) {
            found = false;
            for(int item : itWas){
                if (item == arr[i]){
                    found = true;
                    break;
                }
            }
            if (found && pos != 0) {
               for (int j = i; j < arr.length - 1; j++) {
                   third_cup = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = third_cup;
               }
               i--;
               pos--;
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, arr.length - redacted)));
    }

    public void printListNotLastDivided(int[] arr) {
        System.out.println("Ваш массив");

        int redacted = arr.length - 1;
        int last_elem = arr[arr.length - 1];
        int third_cup;

        for (int i = 0; i < redacted; i++) {
            if (arr[i] % last_elem != 0) {
                for (int j = i; j < arr.length - 1; j++) {
                    third_cup = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = third_cup;
                }
                i--;
                redacted--;
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, redacted + 1)));
    }

}
