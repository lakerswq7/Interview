package linkedlist;

public class LinkedList {
	// ���е�
	// 1,2,3,4 �ҵ����� 2
	// 1,2,3,4,5 �ҵ����� 3
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // merge����list
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ((left != null) && (right != null) ) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return dummy.next;
    }
    
    // ��ת����
    public ListNode reverse(ListNode head) {
    	ListNode newHead = null;
    	ListNode temp;
    	while (head != null) {
    		temp = head.next;
    		head.next = newHead;
    		newHead = head;
    		head = temp;
    	}
    	return newHead;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
