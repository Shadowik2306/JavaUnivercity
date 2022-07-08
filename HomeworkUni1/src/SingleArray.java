public class SingleArray {
    protected int[] singleArr;

    SingleArray() {};

    SingleArray(int size) {
        singleArr = new int[size];
        for (int i = 0; i < size; i++) {
            singleArr[i] = (int) (Math.random() * 11);
        }
    }


    public void swapElems() {
        int ma = -1, indMa = 0;
        int mi = 12, indMi = 0;
        for (int i = 0; i < singleArr.length; i++) {
            if (singleArr[i] % 2 == 0) {
                if (singleArr[i] < mi) {
                    mi = singleArr[i];
                    indMi = i;
                }
            }
            else {
                if (singleArr[i] > ma) {
                    ma = singleArr[i];
                    indMa = i;
                }
            }
        }

        int thirdCup = singleArr[indMi];
        singleArr[indMi] = singleArr[indMa];
        singleArr[indMa] = thirdCup;
    }

    public String print() {
        // return Arrays.toString(arr)
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < singleArr.length; i++) {
            s.append(singleArr[i]);
            if (i != singleArr.length - 1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}
