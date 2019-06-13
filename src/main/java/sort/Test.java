package sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        System.out.println("*********************冒泡排序*********************");
        byte[] by = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        /*冒泡*/
        BubbleSort bs = new BubbleSort();
        bs.Sort(by);

        System.out.println("*********************快速*********************");
        byte[] by1 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
		/*快速*/
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(qs.quick(by1)));

        System.out.println("********************插入**********************");
        byte[] by2 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
		/*插入*/
        InsertSort is = new InsertSort();
        is.Sort(by2);

        System.out.println("********************希尔**********************");
        byte[] by3 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
		/*希尔*/
        ShellSort ss = new ShellSort();
        ss.Sort(by3);

        System.out.println("*******************选择排序**********************");
		/*选择排序*/
        byte[] by4 = new byte[]{6, 9, 11, 3, 4, 15, 13, 10};
        SelectSort ss2 = new SelectSort();
        ss2.Sort(by4);

        System.out.println("********************归并排序**********************");
		/*归并排序*/
        int[] by5 = new int[]{6, 9, 11, 3, 4, 15, 13, 10, 18};
        MergeSort merge = new MergeSort();
        merge.Sort(by5);
    }

}
