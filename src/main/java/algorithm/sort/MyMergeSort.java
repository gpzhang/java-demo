package algorithm.sort;

import java.util.Arrays;

public class MyMergeSort {
    /**
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Comparable> boolean mergeSortRecursive(T[] t) {
        if (t == null || t.length <= 1) return true;

        MSortRecursive(t, 0, t.length - 1);

        return true;
    }

    /**
     * @param <T>
     * @param t
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean MSortRecursive(T[] t, int low, int high) {

        if (t == null || t.length <= 1 || low == high) return true;

        int mid = (low + high) / 2;
        MSortRecursive(t, low, mid);
        MSortRecursive(t, mid + 1, high);
        merge(t, low, mid, high);

        return true;
    }

    /**
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Comparable> boolean mergeSortNonRecursive(T[] t) {
        if (t == null || t.length <= 1) return true;

        int len = 1;
        while (len <= t.length) {
            for (int i = 0; i + len <= t.length - 1; i += len * 2) {
                int low = i, mid = i + len - 1, high = i + len * 2 - 1;
                if (high > t.length - 1) high = t.length - 1;
                merge(t, i, mid, high);
            }

            len *= 2;
        }
        return true;
    }


    /***
     * @param <T>
     * @param t
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean merge(T[] t, int low, int mid, int high) {
        T[] s = t.clone();

        int i, j, k;
        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (t[i].compareTo(t[j]) <= 0) {
                s[k] = t[i++];
            } else {
                s[k] = t[j++];
            }
        }

        if (i <= mid) {
            for (; k <= high; k++) {
                s[k] = t[i++];
            }
        } else {
            for (; k <= high; k++) {
                s[k] = s[j++];
            }
        }
        for (int m = low; m <= high; m++) {
            t[m] = s[m];
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 6, 8, 9, 2, 0, 1, 88, 99, 12, 17};
        long startTime = System.currentTimeMillis();
        //mergeSortNonRecursive(arr);
        mergeSortRecursive(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("ִ��ʱ�䣺" + (endTime - startTime));
        System.out.println(Arrays.toString(arr));
    }
}

