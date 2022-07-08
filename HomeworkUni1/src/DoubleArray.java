public class DoubleArray extends SingleArray {
    private final int[][] arr;

    DoubleArray(int sizeI, int sizeJ) {
        arr = new int[sizeI][sizeJ];
        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                arr[i][j] = (int) (Math.random() * 11);
            }
        }
    }



    public void sortArray() {
        int sumEven = 0, sumOdd = 0;
        int tmp;
        for (int[] ints : arr) {
            for (int i = 0; i < arr[0].length; i++) {
                if (i % 2 == 0) sumEven += ints[i];
                else sumOdd += ints[i];
            }
        }

        if (sumEven > sumOdd) {
            System.out.println("Четных больше");
            for (int[] ints : arr) {
                for (int i = 2; i < arr[0].length; i += 2) {
                    for (int j = i; j < arr[0].length; j += 2) {
                        if (ints[j] > ints[j - 2]) {
                            tmp = ints[j - 2];
                            ints[j - 2] = ints[j];
                            ints[j] = tmp;
                        }
                    }
                }
            }
        } else {
            System.out.println("Нечетных больше");
            for (int[] ints : arr) {
                for (int i = 3; i < arr[0].length; i += 2) {
                    for (int j = i; j < arr[0].length; j += 2) {
                        if (ints[j] > ints[j - 2]) {
                            tmp = ints[j - 2];
                            ints[j - 2] = ints[j];
                            ints[j] = tmp;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void swapElems() {
        int ma = 0, indMa = 0;
        for (int i = 0; i < arr.length; i++) {
            singleArr = arr[i];
            if (print().length() > ma) {
                ma = print().length();
                indMa = i;
            }
        }
        singleArr = arr[indMa];
        super.swapElems();
    }

    public String[] NonHomeworkPrint() {
        String[] lst = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            singleArr = arr[i];
            lst[i] = print();
        }
        return lst;
    }
}
