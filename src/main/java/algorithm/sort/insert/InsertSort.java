package algorithm.sort.insert;

import java.util.Arrays;

/**
 * 基本操作是将一个记录插入到有序集中
 *
 * @author haishen
 */
public class InsertSort {

    /**
     * 核心
     * 1、从第一个元素开始进行插入
     * 2、每次插入后，都保证了已经插入的位置前的所有元素都是有序的了
     *
     * @param by
     * @return
     */
    public byte[] Sort(byte[] by) {
        //从第二个元素开始遍历
        for (int i = 1; i < by.length; i++) {
            int temp = by[i];
            int j = i;
            //判断遍历的元素和前面位置元素的大小关系，如果小于前面位置的元素，则将前面元素后移一位
            while (j > 0 && by[j - 1] > temp) {
                by[j] = by[j - 1];//大于带插入记录的记录后移一位
                j--;
            }
            //最后把遍历的元素置于（插入）空出来的位置上
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
