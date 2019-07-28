package algorithm.tree.t16;

public class CopyOfSolution16 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode ln = null;
		ListNode head = null;
		if (list1 == null && list2 == null) {//无节点
			return null;
		}
		if(list1.next==null&&list2.next==null){//都只有一个节点
			if(list1.val<list2.val){
				ln = list1;
			}else{
				ln=list2;
			}
			return ln;
		}
		if (list1!= null || list2!= null) {
			if (list1.val >= list2.val) {
				ln = list2;
				
				if(list1.next==null&&list2.next==null){//都只有一个节点
					if(list1.val<list2.val){
						ln = list1;
					}else{
						ln=list2;
					}
				}
				
				if(list1.next==null&&list2.next!=null){//list1.next不为null，list2.next为null，
					ln.next=list2.next;
				}
				if(list2.next==null&&list1.next!=null){//list2.next不为null，list1.next为null，
					ln.next=list1.next;
				}
				if(list1.next != null && list2.next != null){
					if (list1.next.val > list2.next.val) {
						ln.next = list2.next;// 指定节点的next的指向
					}else{
						ln.next = list1.next;// 指定节点的next的指向
					}
				}
				
			} else {
				ln = list1;
				if(list1.next==null&&list2.next!=null){//list1.next不为null，list2.next为null，
					ln.next=list2.next;
				}
				if(list2.next==null&&list1.next!=null){//list2.next不为null，list1.next为null，
					ln.next=list1.next;
				}
				if(list1.next != null && list2.next != null){
					if (list1.next.val > list2.next.val) {
						ln.next = list2.next;// 指定节点的next的指向
					}else{
						ln.next = list1.next;// 指定节点的next的指向
					}
				}
			}
		}// 获取第一个节点
		head = ln;// 获取第一个节点
		while (list1.next != null || list2.next != null) {
			if (list1.next != null && list2.next != null) {// 确保获取对象不为null，如果有一个为null,则说明有一个已经比较到最后一个节点，需要跳出while循环，进行特殊处理
				if (list1.val >= list2.val) {
					ln = list2;// 指定节点对象
					if (list1.next.val > list2.next.val) {
						ln.next = list2.next;// 指定节点的next的指向
					}
					list2 = list2.next;// 获取新的对象
				} else {
					ln = list1;// 指定节点对象
					if (list1.next.val > list2.next.val) {
						ln.next = list2.next;// 指定节点的next的指向
					}
					list1 = list1.next;// 获取新的对象
				}
			}else{
				break;
			}

		}
		//进行特殊处理
		if (list1 == null && list2 != null) {
			ln = list2;
			ln.next = list2.next;
			list2 = list2.next;
		} else {
			ln = list1;
			ln.next = list1.next;
			list1 = list1.next;
		}
		return head;

	}

	public static void main(String[] args) {
		CopyOfSolution16 su16 = new CopyOfSolution16();
		ListNode list11 = new ListNode(3);
		ListNode list12 = new ListNode(5);
		ListNode list13 = new ListNode(7);
		ListNode list14 = new ListNode(9);
		ListNode ln1 = new ListNode(1);
		ln1.next = list11;
		list11.next = list12;
		list12.next = list13;
		list13.next = list14;

		System.out.println("===============");
		ListNode list21 = new ListNode(4);
		ListNode list22 = new ListNode(6);
		ListNode list23 = new ListNode(8);
		ListNode list24 = new ListNode(10);
		ListNode ln2 = new ListNode(2);

		ln2.next = list21;
		list21.next = list22;
		list22.next = list23;
		list23.next = list24;
		ListNode MyLn = su16.Merge(ln1, ln2);
		while (MyLn != null) {
			System.out.println(MyLn.val);
			MyLn = MyLn.next;
		}
	}
}
