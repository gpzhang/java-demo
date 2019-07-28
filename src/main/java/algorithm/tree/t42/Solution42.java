package algorithm.tree.t42;

import java.util.ArrayList;
//有序序列中，如果两个元素距离越远，则两个元素的乘积越小
public class Solution42 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2) {
			return list;
		}
		int i = 0, j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			} else if (array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}

		}
		return list;

	}
}
