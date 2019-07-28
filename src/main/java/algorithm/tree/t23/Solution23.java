package algorithm.tree.t23;

import java.util.Arrays;

public class Solution23 {
	public boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0)
			return false;
		int root = sequence[sequence.length - 1];
		int i = 0;
		//找到左子序列
		for (; i < sequence.length - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		int j = i;
		//找到右子序列，并且判断右子序列是否都大于根节点
		for (; j < sequence.length - 1; j++) {
			if (sequence[j] < root)
				return false;
		}
		
		boolean left = true;
		boolean right = true;
		if (i > 0) {
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));//判断左子序列是否是符合规则
		}
		if (i < sequence.length - 1)
			right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i,//判断右子序列是否符合规则
					sequence.length - 1));
		return (left && right);

	}

	public static void main(String[] args) {
		Solution23 su23=new Solution23();
	}
}
