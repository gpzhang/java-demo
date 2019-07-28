package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻元素比较交换、把最大的排到最后。
 * 时间复杂度 O(n^2)
 *
 * @author haishen
 */
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

    public static void main(String[] args) {

        System.out.println("*********************冒泡排序*********************");
        byte[] by = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        /*冒泡*/
        BubbleSort bs = new BubbleSort();
        bs.Sort(by);

    }
}
