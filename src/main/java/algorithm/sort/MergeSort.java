package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序利用了分治的思想来对序列进行排序。
 * 对一个长为n的待排序的序列，我们将其分解成两个长度为n/2的子序列。
 * 每次先递归调用函数使两个子序列有序，然后我们再线性合并两个有序的子序列使整个序列有序。
 *
 * @author haishen
 */
public class MergeSort {

    public byte[] Sort(byte[] nums) {
        byte[] result = mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
        return nums;
    }

    /**
     * 递归
     * 1、
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public byte[] mergeSort(byte[] nums, int l, int r) {
        if (l >= r) {
            return new byte[]{nums[l]};
        }
        int mid = (l + r) >> 1;
        byte[] leftPart = mergeSort(nums, l, mid);
        byte[] rightPart = mergeSort(nums, mid + 1, r);
        return merge(leftPart, leftPart.length, rightPart, rightPart.length);
    }

    /**
     * 用到了88题的合并2个有数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public byte[] merge(byte[] nums1, int m, byte[] nums2, int n) {
        int point1 = 0;
        int point2 = 0;
        byte[] result = new byte[m + n];
        while (point1 < m || point2 < n) {
            byte cur = 0;
            if (point1 == m) {
                cur = nums2[point2];
                point2++;
            } else if (point2 == n) {
                cur = nums1[point1];
                point1++;
            } else if (nums1[point1] < nums2[point2]) {
                cur = nums1[point1];
                point1++;
            } else {
                cur = nums2[point2];
                point2++;
            }
            //当前位置为指针1、2共同走的长度
            result[point1 + point2 - 1] = cur;
        }
        return result;
    }

    public static void main(String[] args) {

        /*归并排序*/
        byte[] by5 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10, 18};
        MergeSort merge = new MergeSort();
        merge.Sort(by5);
        System.out.println(Arrays.toString(by5));
    }

}
