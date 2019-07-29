package algorithm.sort;

import java.util.Arrays;

/**
 * 基本操作是将一个记录插入到有序集中
 *
 * @author haishen
 */
public class InsertSort {

    public byte[] Sort(byte[] by) {
        for (int i = 1; i < by.length; i++) {
            int temp = by[i];
            int j = i;
            while (j > 0 && by[j - 1] > temp) {
                by[j] = by[j - 1];//大于带插入记录的记录后移一位
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
