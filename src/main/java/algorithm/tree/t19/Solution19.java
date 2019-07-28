package algorithm.tree.t19;

import java.util.ArrayList;

public class Solution19 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 输入的二维数组非法，返回空的数组

		// 定义四个关键变量，表示左上和右下的打印范围
		int left = 0, top = 0, right = col - 1, bottom = row - 1;
		while (left <= right && top <= bottom) {
			// 从左到右
			for (int i = left; i <= right; i++)
				list.add(matrix[top][i]);
			// 从上到下
			for (int i = top + 1; i <= bottom; i++)
				list.add(matrix[i][right]);
			//从右到左
			if (top != bottom)
				for (int i = right - 1; i >= left; i--)
					list.add(matrix[bottom][i]);
			//从下到上
			if (left != right)
				for (int i = bottom - 1; i > top; i--)
					list.add(matrix[i][left]);
			left++;
			top++;
			right--;
			bottom--;
		}
		return list;

	}

	public static void main(String[] args) {
		Solution19 su19 = new Solution19();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> al = su19.printMatrix(matrix);
		for (int i : al) {
			System.out.print(i + ",");
		}

	}
}
