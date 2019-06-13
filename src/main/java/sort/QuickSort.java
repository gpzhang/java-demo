package sort;

public class QuickSort {

    public byte[] quick(byte[] by) {
        if (by.length > 0) {
            quickSort(by, 0, by.length - 1);
        }
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
            while (low < high && by[high] >= temp) {
                high--;
            }
            by[low] = by[high];

            while (low < high && by[low] <= temp) {
                low++;
            }
            by[high] = by[low];
        }
        by[low] = (byte) temp;
        return low;
    }
}
