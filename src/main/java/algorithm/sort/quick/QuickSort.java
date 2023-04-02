package algorithm.sort.quick;

import java.util.Arrays;

/**
 * @author haishen
 * 排序思想：
 * 是对冒泡排序的一种改进
 * <p>
 * 1，取一个元素作为基准数字，将数组分为左右两部分，左边是比它小的数字，右边是比它大的数字；
 * <p>
 * 2，将左部分按照上面的思想再次进行划分成两部分，依次类推；
 * <p>
 * 3，将右部分按照上面的思想再次进行划分成两部分，依次类推；
 */
public class QuickSort {

    public byte[] quick(byte[] by) {
        if (by == null || by.length == 0) {
            return by;
        }
        quickSort(by, 0, by.length - 1);
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
            //从高位递减,找到第一个小于比较基数的元素，并将比较基数置于对应低位
            while (low < high && by[high] >= temp) {
                high--;
            }
            by[low] = by[high];

            //从低位递增,找到第一个不小于比较基数的元素，并将比较基数置于对应高位
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
