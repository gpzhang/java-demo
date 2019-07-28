package algorithm.tree.t27;

import java.util.ArrayList;

public class Solution27 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array==null)
			return;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(array[i]))
				list.add(array[i]);
			else
				list.remove(new Integer(array[i]));
		}
		if (list.size() > 1) {
			num1[0] = list.get(0);
			num2[0] = list.get(1);
		}
	}
}
