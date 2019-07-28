package algorithm.tree.t18;

public class Solution18 {
	//递归的实现方式
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		if (root != null) {
			swapTree(root);
			Mirror(root.left);
			Mirror(root.right);

		}
	}

	public void swapTree(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

	}

	public static void main(String[] args) {

	}
}
