package algorithm.sort;

import java.util.Arrays;

/**
 * 每一趟从待排序的记录中选出最小的元素，
 * 并将选中比较的元素和和本次比较最小元素的位置互换，直到全部记录排序完毕。
 * 时间复杂度 O(n^2)
 *
 * @author haishen
 */
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

    public static void main(String[] args) {

		/*选择排序*/
        byte[] by4 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        SelectSort ss2 = new SelectSort();
        ss2.Sort(by4);

    }
}
