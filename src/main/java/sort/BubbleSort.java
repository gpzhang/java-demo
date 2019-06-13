package sort;

import java.util.Arrays;

public class BubbleSort {
    public byte[] Sort(byte[] by) {
        for (int i = 0; i < by.length; i++) {
            //
            for (int j = 0; j < by.length - i - 1; j++) {
                if (by[j] > by[j + 1]) {
                    byte temp = by[j + 1];
                    by[j + 1] = by[j];
                    by[j] = temp;
                }
            }
            System.out.println("" + (i + 1) + "" + Arrays.toString(by));
        }
        return by;
    }
}
