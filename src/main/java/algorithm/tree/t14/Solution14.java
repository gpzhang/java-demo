package algorithm.tree.t14;

public class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        int geShu = 1;
        ListNode temp = head;//把引用赋给变量temp
        while (temp.next != null) {
            geShu++;
            temp = temp.next;//这一步操作,表明了给temp创建了一个新的对象，每次while循环执行到这，都会创建一个新的对象。从而不会影响到head对象的各属性
        }
        int index = geShu - k;
        if (index >= 0) {
            while (head.next != null && index != 0) {
                index--;
                head = head.next;
            }
        } else {
            return null;
        }

        return head;

    }

    public static void main(String[] args) {
        Solution14 su14 = new Solution14();
        ListNode head01 = new ListNode(1);
        ListNode head02 = new ListNode(2);
        ListNode head03 = new ListNode(3);
        ListNode head04 = new ListNode(4);
        ListNode head05 = new ListNode(5);
        head01.next = head02;
        head02.next = head03;
        head03.next = head04;
        head04.next = head05;
        ListNode ln = su14.FindKthToTail(head01, 1);
    }
}
