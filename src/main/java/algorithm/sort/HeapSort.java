package algorithm.sort;

public class HeapSort {


    public void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent];

        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            if (temp >= array[child]) {
                break;
            }

            array[parent] = array[child];
            parent = child;
            child = 2 * parent + 1;
        }

        array[parent] = temp;
    }

    public void heapSort(int[] list) {
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(list, i, list.length);
        }
        for (int i = list.length - 1; i > 0; i--) {
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            HeapAdjust(list, 0, i);
            System.out.format("%d: \t", list.length - i);
            printPart(list, 0, list.length - 1);
        }
    }

    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {45, 78, 57, 25, 41, 89};

        HeapSort heap = new HeapSort();
        System.out.print(":\t");
        heap.printPart(array, 0, array.length - 1);
        heap.heapSort(array);
        System.out.print(":\t");
        heap.printPart(array, 0, array.length - 1);
    }

}