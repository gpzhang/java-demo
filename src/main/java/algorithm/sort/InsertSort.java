package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public byte[] Sort(byte[] by) {
        for (int i = 1; i < by.length; i++) {
            int temp = by[i];
            int j = i;
            while (j > 0 && by[j - 1] > temp) {

                by[j] = by[j - 1];
                j--;
            }
            by[j] = (byte) temp;
            System.out.println("" + (i) + "" + Arrays.toString(by));
        }
        return by;
    }

    public byte[] mySort(byte[] by) {
        for (int i = 1; i < by.length; i++) {
            int temp = by[i];
            int j = i;
            while (j > 0 && temp < by[j - 1]) {
                by[j] = by[j - 1];
                j--;
            }
            by[j] = (byte) temp;
            System.out.println("" + (i) + "" + Arrays.toString(by) + "::");
        }
        return by;
    }
}
