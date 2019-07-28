package algorithm.tree.t56;

public class Solution56 {
	public ListNode deleteDuplication(ListNode pHead) {
		ListNode q, p, r;
		p = pHead;
		q = r = null;

		while (p != null) {
			boolean flag = false;
			r = p.next;
			while (r != null && r.val == p.val) {
				flag = true;
				r = r.next;
			}
			if (flag) {
				if (q != null)
					q.next = r;
				else
					pHead = null;
			} else {
				if (q == null)
					pHead = p;
				q = p;
			}
			p = r;
		}

		return pHead;

	}

	public static void main(String[] args) {
		Solution56 su56 = new Solution56();
		ListNode head01 = new ListNode(1);
		ListNode head02 = new ListNode(2);
		ListNode head03 = new ListNode(3);
		ListNode head33 = new ListNode(3);
		ListNode head04 = new ListNode(4);
		ListNode head44 = new ListNode(4);
		ListNode head05 = new ListNode(5);
		head01.next = head02;
		head02.next = head03;
		head03.next = head33;
		head33.next = head04;
		head04.next = head44;
		head44.next = head05;
		ListNode pHead = su56.deleteDuplication(head01);
		while (pHead != null) {
			System.out.print(pHead.val + "->");
			pHead = pHead.next;
		}
	}
}
