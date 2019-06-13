package sort;

import java.util.Arrays;

public class ShellSort {
    public byte[] Sort(byte[] by) {
        int d = by.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {

                for (int i = x + d; i < by.length; i = i + d) {
                    int temp = by[i];
                    int j;
                    for (j = i - d; j >= 0 && temp < by[j]; j = j - d) {
                        by[j + d] = by[j];
                    }
                    by[j + d] = (byte) temp;
                }
                System.out.println("" + (x + 1) + "" + Arrays.toString(by));
            }
            if (d == 1) {
                break;
            }
        }
        return by;
    }

    public byte[] MySort(byte[] by) {
        int d = by.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < by.length; i = i + d) {
                    int temp = by[i];
                    int j;
                    for (j = i - d; j >= 0 && temp < by[j]; j = j - d) {
                        by[j + d] = by[j];
                    }
                    by[j + d] = (byte) temp;
                }
            }
            System.out.println("" + Arrays.toString(by));
            if (d == 1) {
                break;
            }
        }
        return by;
    }
}
