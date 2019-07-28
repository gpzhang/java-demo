package algorithm.tree.bin.tree;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author haishen
 */
public class BianLi {
    /**
     * 先序创建二叉树,限制条件太少，构建的二叉树不唯一。
     */
    public TreeNode CreateTree(int[] array) {
        TreeNode root = new TreeNode(0);

        return root;

    }

    //先序遍历
    public void PreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + ",");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    //中序遍历
    public void InOrder(TreeNode root) {
        if (root == null)
            return;
        InOrder(root.left);
        System.out.print(root.val + ",");
        InOrder(root.right);

    }

    //后序遍历
    public void PostOrder(TreeNode root) {
        if (root == null)
            return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val + ",");
    }

    //从上到下，从左到右遍历二叉树
    public void PrintOrder(TreeNode root) {
        if (root == null)
            return;
        //借助一个队列，由队列的特点可以实现顺序遍历的要求
        LinkedBlockingQueue<TreeNode> lbkq = new LinkedBlockingQueue<TreeNode>();
        lbkq.offer(root);
        while (!lbkq.isEmpty()) {
            TreeNode tn = lbkq.poll();
            System.out.print(tn.val + ",");
            if (tn.left != null) {
                lbkq.offer(tn.left);
            }
            if (tn.right != null) {
                lbkq.offer(tn.right);
            }
        }
    }

    //计算二叉树的深度
    public int GetTreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftLength = GetTreeDepth(root.left);
        int rightLength = GetTreeDepth(root.right);
        int depth = leftLength > rightLength ? leftLength : rightLength;
        return depth + 1;

    }

    //判断二叉树是否为平衡二叉树
    public boolean IsBalanceTree(TreeNode root) {
        if (root == null)
            return true;
        int leftLength = GetTreeDepth(root.left);
        int rightLength = GetTreeDepth(root.right);
        int distance = leftLength > rightLength ? (leftLength - rightLength) : (rightLength - leftLength);
        if (distance > 1)
            return false;
        else
            return IsBalanceTree(root.left) && IsBalanceTree(root.right);

    }


    public static void main(String[] args) {
        BianLi bl = new BianLi();
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        int depth = bl.GetTreeDepth(treeNode);
        System.out.println(depth);
        System.out.println(bl.IsBalanceTree(treeNode));
    }
}
