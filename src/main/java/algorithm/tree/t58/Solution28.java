package algorithm.tree.t58;

public class Solution28 {
	// 左右方向同时遍历
	boolean isSymmetrical(TreeNode pRoot) {
		return doubleVisit(pRoot, pRoot);
	}

	boolean doubleVisit(TreeNode p1, TreeNode p2) {
		if (p1 == null && p2 == null)
			return true;
		if (p1 == null || p2 == null)
			return false;
		if (p1.val == p2.val)
			return doubleVisit(p1.left, p2.right)
					&& doubleVisit(p1.right, p2.left);
		return false;
	}

	public static void main(String[] args) {
		Solution28 su28 = new Solution28();
		TreeNode treeNode = new TreeNode(8);
		/*
		 * TreeNode treeNode2=new TreeNode(6); TreeNode treeNode3=new
		 * TreeNode(6); TreeNode treeNode4=new TreeNode(5); TreeNode
		 * treeNode5=new TreeNode(7); TreeNode treeNode6=new TreeNode(7);
		 * TreeNode treeNode7=new TreeNode(5);
		 */

		/*
		 * treeNode.left=treeNode2; treeNode.right=treeNode3;
		 * 
		 * treeNode2.left=treeNode4; treeNode2.right=treeNode5;
		 * 
		 * treeNode3.left=treeNode6; treeNode3.right=treeNode7;
		 */
		boolean bs = su28.isSymmetrical(treeNode);
		System.out.println(bs);
	}
}
