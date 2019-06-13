package sort;

import java.util.Arrays;

public class SelectSort {
    public byte[] Sort(byte[] by) {
        for (int i = 0; i < by.length; i++) {
            int min = by[i];
            int n = i;
            for (int j = i + 1; j < by.length; j++) {
                if (by[j] < min) {
                    min = by[j];
                    n = j;
                }
            }
            by[n] = by[i];
            by[i] = (byte) min;
            System.out.println("" + (i + 1) + "" + Arrays.toString(by));
        }
        return by;
    }

    public byte[] mysort(byte[] by) {
        for (int i = 0; i < by.length; i++) {
            int min = by[i];
            int positionIndex = i;
            for (int j = i + 1; j < by.length; j++) {
                if (by[j] < min) {
                    min = by[j];
                    positionIndex = j;
                }
            }
            by[positionIndex] = by[i];
            by[i] = (byte) min;
            System.out.println("" + (i + 1) + "" + Arrays.toString(by) + " :::");
        }
        return by;
    }
}
