package algorithm.sort.other;

/**
 * 基数排序，不需要进行位置交换
 *
 * @author haishen
 */
public class RadixSort {

    public int getDigit(int x, int d) {
        int a[] = {1, 1, 10, 100};
        return ((x / a[d]) % 10);
    }

    public void radixSort(int[] list, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] count = new int[radix];
        int[] bucket = new int[end - begin + 1];

        for (int d = 1; d <= digit; d++) {

            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }

            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = end; i >= begin; i--) {
                j = getDigit(list[i], d);
                bucket[count[j] - 1] = list[i];
                count[j]--;
            }

            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }

        }

    }

    public int[] sort(int[] list) {
        radixSort(list, 0, list.length - 1, 3);
        return list;
    }

    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {50, 123, 543, 187, 49, 30, 0, 2, 11, 100, 15};
        RadixSort radix = new RadixSort();
        System.out.print(":\t\t");
        radix.printAll(array);
        radix.sort(array);
        System.out.print(":\t\t");
        radix.printAll(array);
    }

}