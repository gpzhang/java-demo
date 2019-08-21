package algorithm.sort;

import java.util.Arrays;

/**
 * @author haishen
 *         排序思想：
 *         <p>
 *         1，希尔排序属于插入排序算法；
 *         <p>
 *         2，希尔排序是插入排序算法的优化，插入算法在插入过程中要移动很多次数字，几趟下来，移动次数就多不胜数，希尔排序的思想是先设法将数组排列成大致有序的，这样再进行插入排序是就会减少大量移动，从而优化算法；
 *         <p>
 *         3，将数组调整成大致有序的步骤按照原理被称为缩小增量法，即每次拿一个数跟（增量间隔）后的数比较，按大小调整位置（调整方法为插入排序法），每趟执行完后增量减少一半，依次类推，直到增量减少为1，即进行最后一次的直接插入排序（可参考本系列直接插入排序算法帖子）
 */
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

    public static void main(String[] args) {

        byte[] by3 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        /*希尔*/
        ShellSort ss = new ShellSort();
        ss.Sort(by3);

    }
}
