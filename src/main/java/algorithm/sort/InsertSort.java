package algorithm.sort;

import java.util.Arrays;

/**
 * @author haishen
 */
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

    public static void main(String[] args) {

        byte[] by2 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        /*插入*/
        InsertSort is = new InsertSort();
        is.Sort(by2);

    }
}
