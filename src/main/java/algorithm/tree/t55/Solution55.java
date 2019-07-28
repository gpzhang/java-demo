package algorithm.tree.t55;

public class Solution55 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {

		if (pHead == null || pHead.next == null)
			return null;
		ListNode slow = pHead;
		ListNode fast = pHead;
		while (slow != null && fast != null) {
			slow = slow.next;// 走一步，下一个节点，需要判断slow节点是否为空
			fast = fast.next.next;// 走两步，下下个节点，需要判断fast节点是否为空
			if (slow.val == fast.val) {
				slow=pHead;//设置一个从头结点开始的指针，与之前slow和fast相遇的节点
				
				while(slow!=fast){//有公式推导出，当两个指针相遇时，相遇的节点即为入口处
					slow=slow.next;
					fast=fast.next;
				}
				if(slow==fast)
					return slow;
			}

		}
		return null;

	}

	public static void main(String[] args) {
		Solution55 su55 = new Solution55();
		ListNode pHead = new ListNode(1);
		ListNode pHead2 = new ListNode(2);
		pHead.next = pHead2;
		pHead2.next = pHead;
		ListNode ln = su55.EntryNodeOfLoop(pHead);
		System.out.println(ln.val);
		
	}
}
