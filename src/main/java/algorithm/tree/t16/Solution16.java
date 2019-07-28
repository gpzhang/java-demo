package algorithm.tree.t16;

import java.util.ArrayList;
import java.util.List;

public class Solution16 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode ln = null;
		ListNode head = null;
		List<Integer> arrayList = new ArrayList<Integer>();
		if (list1 == null && list2 == null) {// 无节点
			return null;
		}
		if (list1 == null && list2 != null) {
			return list2;
		}
		if (list2 == null && list1 != null) {
			return list1;
		}
		if (list1.next == null && list2.next == null) {// 都只有一个节点
			if (list1.val < list2.val) {
				ln = list1;
				ln.next = list2;
			} else {
				ln = list2;
				ln.next = list1;
			}
			return ln;
		}
		while (list1.next != null && list2.next != null) {
			if (list1.val < list2.val) {
				arrayList.add(list1.val);
				list1 = list1.next;
			} else {
				arrayList.add(list2.val);
				list2 = list2.next;
			}
		}

		if (list1 != null && list1.next == null) {// list1走到最后一个节点
			while (list2 != null) {
				if (list1 != null && list1.val <= list2.val) {
					arrayList.add(list1.val);
					list1 = null;
				} else {
					arrayList.add(list2.val);
					list2 = list2.next;
				}
			}

		}

		if (list2 != null && list2.next == null) {// list2走到最后一个节点
			while (list1 != null) {
				if (list2 != null && list2.val <= list1.val) {
					arrayList.add(list2.val);
					list2 = null;
				} else {
					arrayList.add(list1.val);
					list1 = list1.next;
				}
			}

		}
		ln = new ListNode(arrayList.get(0));
		ln.next = new ListNode(arrayList.get(1));
		head = ln;// 获取第一个节点
		for (int i = 1; i < arrayList.size(); i++) {
			ln = ln.next;
			if (i + 1 == arrayList.size()) {
				ln.next = null;
			} else {
				ln.next = new ListNode(arrayList.get(i + 1));
			}
		}
		return head;

	}

	public static void main(String[] args) {
		Solution16 su16 = new Solution16();
		ListNode ln1 = new ListNode(1);

		System.out.println("===============");
		ListNode ln2 = new ListNode(2);

		ListNode MyLn = su16.Merge(ln1, null);
		while (MyLn != null) {
			System.out.println(MyLn.val);
			MyLn = MyLn.next;
		}
	}
}
