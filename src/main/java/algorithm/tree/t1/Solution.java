package algorithm.tree.t1;


import algorithm.tree.t1.list.ListNode;
import algorithm.tree.t1.list.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean Find(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > target) {// 如果成立，该行不需要再进行比较，因为后面的更大
                    break;
                }
                if (target == array[i][j]) {
                    return true;
                }

            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        String s = str.append("A").toString();
        String[] arrayStr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrayStr.length; i++) {
            if (i == arrayStr.length - 1) {
                sb.append(arrayStr[i]);
                break;
            }
            sb.append(arrayStr[i]).append("%20");
        }
        return sb.toString().substring(0, sb.length() - 1);

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
            stack.push(new Integer(temp.val));
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            a.add(stack.pop());
        }
        return a;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        if (pre.length == in.length && pre.length == 1) {
            TreeNode tn = new TreeNode(pre[0]);
            tn.left = null;
            tn.right = null;
            return tn;
        }
        int index = 0, length = 0;
        TreeNode tn = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {// 查找根节点在中序遍历中的位置
            if (pre[0] == in[i]) {
                index = i;
                break;
            }
        }
        int leftArrayPre[] = new int[index];// 左节点的前序遍历
        int leftArrayIn[] = new int[index];// 初始化左节点的中序遍历

        int rightArrayPre[] = new int[in.length - index - 1];// 右节点的前序遍历
        int rightArrayIn[] = new int[in.length - index - 1];// 初始化右节点的中序遍历

        if (index >= in.length) {
            System.out.println("没有");
            return null;
        }

        if (index > 0) {// 左子树递归
            length = index;
            System.arraycopy(in, 0, leftArrayIn, 0, length);// 获取左子树的中序子序列
            System.arraycopy(pre, 1, leftArrayPre, 0, length);// 获取左子树的前序子序列
            tn.left = reConstructBinaryTree(leftArrayPre, leftArrayIn);
        }
        if (index < in.length) {// 右子树递归
            length = in.length - index - 1;
            System.arraycopy(in, index + 1, rightArrayIn, 0, length);// 获取右子树的中序子序列
            System.arraycopy(pre, index + 1, rightArrayPre, 0, length);// 获取右子树的前序子序列
            tn.right = reConstructBinaryTree(rightArrayPre, rightArrayIn);
        }
        return tn;

    }

    Stack<Integer> stack1 = new Stack<Integer>();// 进数据栈
    Stack<Integer> stack2 = new Stack<Integer>();// 出数据栈

    public void push(int node) {

        stack1.push(node);

    }

    public int pop() {

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int i = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());// 每次出去一个数据之后,把出数据栈剩余的数据放回进数据栈
        }
        return i;

    }

    public int minNumberInRotateArray(int[] array) {

        return 0;

    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (0 < n && n <= 2) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

    }

    public int JumpFloor(int target) {
        if (target <= 0)
            return -1;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }

    public int JumpFloorII(int target) {
        if (target <= 0)
            return -1;
        if (target == 1)
            return 1;
        return 2 * JumpFloorII(target - 1);

    }

    public int RectCover(int target) {
        if (target < 0)
            return -1;
        if (target == 0)
            return 1;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }

    public int NumberOf1(int n) {
        int size = 0;
        for (int i = 0; i < 32; i++) {
            size += n & 1;
            n = n >> 1;
        }
        return size;

    }

    public double Power(double base, int exponent) {
        double result = 1;
        if (exponent > 0) {
            for (int i = exponent; i > 0; i--) {
                result = result * base;
            }
        } else {
            for (int i = (0 - exponent); i > 0; i--) {
                result = result * (1 / base);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int array[][] = new int[][]{{1, 2, 3}, {2, 4, 5}, {3, 7, 9}};
        Solution su = new Solution();
        StringBuffer str = new StringBuffer("we are man! ");
        // System.out.println(su.replaceSpace(str));

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ArrayList<Integer> bb = printListFromTailToHead(a);
        // System.out.println(bb.get(0) + "----" + bb.get(1) + "------"
        // +bb.get(2) + "------" + bb.get(3));

        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode tn = su.reConstructBinaryTree(pre, in);

        su.push(1);
        su.push(2);
        su.push(3);
        su.push(4);
        System.out.println(su.pop());
        su.push(5);
        System.out.println(su.pop());

        int s = su.Fibonacci(4);
        System.out.println("s:" + s);
        int i = 0xFF;
        System.out.println(su.NumberOf1(i));
        System.out.println(su.Power(2, -3));
    }
}
