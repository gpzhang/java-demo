package algorithm.sort.select;

import java.util.Arrays;

/**
 * 每一趟从待排序的记录中选出最小的元素，
 * 并将选中比较的元素和和本次比较最小元素的位置互换，直到全部记录排序完毕。
 * 时间复杂度 O(n^2)
 *
 * @author haishen
 */
public class SelectSort {

    /**
     * 核心步骤
     * 1、遍历
     * 2、比较，选出最小
     * 3、交换
     *
     * @param by
     * @return
     */
    public byte[] Sort(byte[] by) {
        //从头开始遍历元素
        for (int i = 0; i < by.length; i++) {
            int minIndex = i;
            //从遍历元素后第一个元素的位置开始往后比较，如果后面的元素更小，更新最小值，并记录索引到的位置
            for (int j = i + 1; j < by.length; j++) {
                if (by[j] < by[minIndex]) {
                    minIndex = j;
                }
            }
            swap(by, i, minIndex);
            System.out.println("" + (i + 1) + "" + Arrays.toString(by));
        }
        return by;
    }

    /**
     * 交换元素
     *
     * @param by
     * @param indexA
     * @param indexB
     */
    private void swap(byte[] by, int indexA, int indexB) {
        byte temp = by[indexA];
        by[indexA] = by[indexB];
        by[indexB] = temp;
    }

    public static void main(String[] args) {

        /*选择排序*/
        byte[] by4 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        SelectSort ss2 = new SelectSort();
        ss2.Sort(by4);

    }
}
