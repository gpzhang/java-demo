package algorithm.tree.t6;

import java.util.Arrays;

//旋转数组，分块有序，求出每一块中的最小值，进行下一块比较即可
public class Solution06 {
	public int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}

		int length, low, high, mid = 0;
		length = array.length;
		low = 0;
		high = length - 1;
		if (array[low] < array[high]) {//如果数组有序，则直接输出数组第一个元素即为最小值
			return array[low];
		}
		if (length == 1) {
			return array[high];
		}
		while (low < high) {
			if ((high - low) == 1) {
				return array[high];
			}
			mid = (high + low) / 2;

			if (array[mid] == array[low] && array[mid] == array[high]) {
				int index = low;
				for (int i = low + 1; i <= high; i++) {
					if (array[i] < array[index])//
						index = i;
				}
				return array[index];
			}
			if (array[mid] >= array[low]) {// 条件成立时：[low,...,mid]递增
				low = mid;// mid之前的数据被pass掉
			} else if (array[mid] <=array[high]) {// 条件成立时：[mid,...,high]非递减
				high = mid;// high之后的数据被pass掉,不会出现最小值
			}

		}
		return 0;
		

	}

	public static void main(String[] args) {
		Solution06 su = new Solution06();
		int[] array = new int[] {2};
		int min = su.minNumberInRotateArray(array);
		System.out.println(Arrays.toString(array) + "||最小值：" + min);
	}
}
