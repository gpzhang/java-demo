package algorithm.tree.t15;

import java.util.Stack;

public class Solution15 {
	public ListNode ReverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		if(head==null){
			return null;
		}
		if (head.next == null)
			return head;
		
		while (head!= null) {
			stack.push(head);
			head = head.next;
		}

		ListNode ln = null;
		head=stack.peek();
		while (!stack.isEmpty()) {
			ln = stack.pop();//取出对象
			if (stack.isEmpty()) {
				ln.next = null;
			} else {
				ln.next = stack.peek();//修改对象的next指向
				ln = ln.next;
			}

		}

		return head;

	}

	public static void main(String[] args) {
		Solution15 su15 = new Solution15();
		ListNode head01 = new ListNode(1);
		ListNode head02 = new ListNode(2);
		ListNode head03 = new ListNode(3);
		ListNode head04 = new ListNode(4);
		ListNode head05 = new ListNode(5);
		head01.next = head02;
		head02.next = head03;
		head03.next = head04;
		head04.next = head05;
		ListNode ln = su15.ReverseList(head01);
		while (ln!= null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
}
