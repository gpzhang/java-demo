package algorithm.sort.select;

import java.util.Arrays;

/**
 * 堆排序
 * 1、构建堆
 * 2、堆调整
 * 3、堆排序
 *
 * @author haishen
 */
public class HeapSort {

    /**
     * @param array
     * @param parent 父节点的索引
     * @param length
     */
    public void HeapAdjust(byte[] array, int parent, int length) {
        byte parentNodeValue = array[parent];
        //左子节点的索引
        int child = 2 * parent + 1;
        while (child < length) {
            int rightChild = child + 1;
            //右子节点存在，且更大，则调整节点位置
            if (rightChild < length && array[child] < array[rightChild]) {
                child++;
            }

            if (array[child] > parentNodeValue) {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public void heapSort(byte[] list) {
        //1、通过调整的方式，创建堆
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(list, i, list.length);
        }
        for (int i = list.length - 1; i > 0; i--) {
            //2、交换元素，通过交换，使得最大的元素逐个沉底（即每一次堆调整后，第一个元素都是相对最大的）
            swap(list, i, 0);
            //3、堆调整
            HeapAdjust(list, 0, i);
        }
    }

    /**
     * 交换元素K
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
        byte[] array = {45, 78, 57, 25, 41, 89};
        HeapSort heap = new HeapSort();
        heap.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}