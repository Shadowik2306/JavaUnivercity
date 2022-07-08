import java.util.Arrays;

public class MyDoubleList extends MyList{
    public MyDoubleList() {
        super();
    }

    @Override
    public void randomIn() {
        System.out.println("Введите сколько элементов по столбцам");
        int rangeA;
        while (true) {
            try {
                rangeA = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error, не число");
                System.exit(0);
            }
        }

        System.out.println("Введите сколько элементов по строке");
        int rangeB;
        while (true) {
            try {
                rangeB = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error, не число");
                System.exit(0);
            }
        }

        int[][] arr = new int[rangeA][rangeB];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = (int) Math.round((Math.random() * 30) - 15);
            }
        }
        addNewLine(arr);
    }

    public void addNewLine(int[][] arr) {
        int maxValue = arr[0][0];
        int maxLine = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (maxValue < arr[i][j]) {
                    maxLine = i;
                    maxValue = arr[i][j];
                }
            }
        }

        int[][] newArr = new int[arr.length * 2][arr[0].length];
        int pos = 0;
        boolean key;
        for (int[] ints : arr) {
            key = false;
            for (int j = 0; j < arr[0].length; j++) {
                if (ints[j] != 0) {
                    if ((Math.abs(arr[0][0]) + Math.abs(arr[arr.length - 1][arr[0].length - 1])) % ints[j] == 0) {
                        key = true;
                        break;
                    }
                }
            }
            newArr[pos++] = ints;
            if (key) {
                newArr[pos++] = arr[maxLine];
            }
        }

        for (int[] item: arr) {
            System.out.println(Arrays.toString(item));
        }

        System.out.println();

        for (int[] item: Arrays.copyOfRange(newArr, 0, pos)) {
            System.out.println(Arrays.toString(item));
        }

    }

    @Override
    public void specialIn() {
        System.out.println("Введите сколько элементов по столбцам");
        int rangeA;
        while (true) {
            try {
                rangeA = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error, не число");
                System.exit(0);
            }
        }

        System.out.println("Введите сколько элементов по строке");
        int rangeB;
        while (true) {
            try {
                rangeB = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error, не число");
                System.exit(0);
            }
        }

        System.out.println("Введите элементы");
        int[][] arr = new int[rangeA][rangeB];
        int a;
        while (rangeA > 0) {
            while (rangeB > 0) {
                while (true) {
                    try {
                        a = in.nextInt();
                        arr[arr.length - rangeA][arr[0].length - rangeB] = a;
                        rangeB--;
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, не число");
                        System.exit(0);
                    }
                }
            }
            rangeA--;
            rangeB = arr[0].length;
        }
        addNewLine(arr);
    }

    public void printDoubleList(int[][] arr) {
        System.out.println("Ваш массив");
        for (int[] j : arr) {
            System.out.println(Arrays.toString(j));
        }
    }

    public void findMinMax(int[][] arr) {
        int sum = 0;
        int middle = arr[0].length / 2;
        if (arr[0].length % 2 == 1) {
            middle++;
        }
        if (findMin(arr, middle) > findMax(arr, middle)) {
            if (arr.length == arr[0].length) {
                System.out.println("По гл. диагонали");
                for (int i = 0; i < arr.length; i++) {
                    sum += arr[i][i];
                }
            }
            else {
                System.out.println("Не думаю что это возможно");
            }
        }
        else {
            System.out.println("По первой строке");
            for (int i = 0; i < arr[0].length; i++) {
                sum += arr[0][i];
            }
        }

        System.out.println(sum);
    }

    public int findMin(int[][] arr, int middle) {
        int min = arr[0][0];
        for (int[] itemArr : arr) {
            for (int i = 0; i < middle; i++) {
                if (itemArr[i] < min) {
                    min = itemArr[i];
                }
            }
        }
        return min;
    }

    public int findMax(int[][] arr, int middle) {
        int max = arr[0][arr[0].length - 1];
        for (int[] itemArr : arr) {
            for (int i = middle; i < arr[0].length; i++) {
                if (itemArr[i] > max) {
                    max = itemArr[i];
                }
            }
        }
        return max;
    }
}
