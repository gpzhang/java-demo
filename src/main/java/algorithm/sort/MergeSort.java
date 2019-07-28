package algorithm.sort;

import java.util.Arrays;

/**
 * @author haishen
 */
public class MergeSort {

    public void Merge(int[] array, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] arrayTemp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                arrayTemp[k] = array[i];
                i++;
                k++;
            } else {
                arrayTemp[k] = array[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            arrayTemp[k] = array[i];
            i++;
            k++;
        }
        while (j <= high) {
            arrayTemp[k] = array[j];
            j++;
            k++;
        }
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = arrayTemp[k];
        }

    }

    /**
     * @param array
     * @param gap
     * @param length
     */
    public void MergePass(int[] array, int gap, int length) {

        int i = 0;

        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }

        System.out.println("(" + i + "+" + gap + "-1)=" + (i + gap - 1) + "==" + length);
        if (i + gap - 1 < length) {
            Merge(array, i, i + gap - 1, length - 1);
        }
    }

    public int[] Sort(int[] list) {
        int cishu = 0;
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            MergePass(list, gap, list.length);
            System.out.println("" + (++cishu) + "" + Arrays.toString(list));
        }
        return list;
    }

    public static void main(String[] args) {

		/*归并排序*/
        int[] by5 = new int[]{6, 9, 11, 3, 4, 15, 13, 10, 18};
        MergeSort merge = new MergeSort();
        merge.Sort(by5);
    }

}
