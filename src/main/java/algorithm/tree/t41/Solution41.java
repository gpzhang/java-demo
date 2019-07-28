package algorithm.tree.t41;

import java.util.ArrayList;

public class Solution41 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> alal = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= sum / 2; i++) {
			ArrayList<Integer> al = new ArrayList<>();
			int tempSum = i;
			int nextNum = i;
			al.add(i);
			while (tempSum < sum) {
				nextNum++;
				al.add(nextNum);
				if ((tempSum += nextNum) == sum) {
					alal.add(al);
					break;
				}

			}
		}
		return alal;

	}
}
