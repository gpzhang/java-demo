package algorithm.tree.t22;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution22 {
	// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return list;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		// 树根入队
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			list.add(treeNode.val);
			// 左孩子入队
			if (treeNode.left != null) {
				queue.offer(treeNode.left);
			}
			// 右孩子入队
			if (treeNode.right != null) {
				queue.offer(treeNode.right);
			}
		}
		return list;

	}

	public static void main(String[] args) {
		Solution22 su22=new Solution22();
		TreeNode treeNode=new TreeNode(1);
		TreeNode treeNode2=new TreeNode(2);
		TreeNode treeNode3=new TreeNode(3);
		TreeNode treeNode4=new TreeNode(4);
		TreeNode treeNode5=new TreeNode(5);
		TreeNode treeNode6=new TreeNode(6);
		
		treeNode.left=treeNode2;
		treeNode.right=treeNode3;
		treeNode2.left=treeNode4;
		treeNode2.right=treeNode5;
		treeNode3.left=treeNode6;
		
		ArrayList<Integer> list=su22.PrintFromTopToBottom(treeNode);
		for(int i:list){
			System.out.print(i+",");
		}
	}

}
