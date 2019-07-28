package algorithm.sort;

import java.util.Arrays;

/**
 * @author haishen
 */
public class QuickSort {

    public byte[] quick(byte[] by) {
        if (by.length > 0) {
            quickSort(by, 0, by.length - 1);
        }
        return by;
    }

    private void quickSort(byte[] by, int low, int high) {
        if (low < high) {
            int middle = getMiddle(by, low, high);
            quickSort(by, 0, middle - 1);
            quickSort(by, middle + 1, high);
        }
    }

    private int getMiddle(byte[] by, int low, int high) {
        int temp = by[low];
        while (low < high) {
            while (low < high && by[high] >= temp) {
                high--;
            }
            by[low] = by[high];

            while (low < high && by[low] <= temp) {
                low++;
            }
            by[high] = by[low];
        }
        by[low] = (byte) temp;
        return low;
    }

    public static void main(String[] args) {

        byte[] by1 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        /*快速*/
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(qs.quick(by1)));


    }
}
