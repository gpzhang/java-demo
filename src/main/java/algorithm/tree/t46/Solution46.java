package algorithm.tree.t46;

public class Solution46 {
	public int Sum_Solution(int n) {
		if (n >= 0 && n <= 1)
			return n;
		n = n + Sum_Solution(n - 1);
		return n;

	}

	// 不用加减乘除做加法
	public int Add(int num1, int num2) {
		if (num1 >= 0 && num2 >= 0) {
			
		}
		if (num1 < 0 && num2 >= 0) {

		}
		if (num1 >= 0 && num2 < 0) {

		}
		if (num1 < 0 && num2 < 0) {

		}
		return num2;

	}

	public static void main(String[] args) {
		Solution46 su46 = new Solution46();
		System.out.println(su46.Sum_Solution(8));
	}
}
