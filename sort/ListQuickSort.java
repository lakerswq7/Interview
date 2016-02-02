package sort;

public class ListQuickSort {
    public ListNode sortList(ListNode head) {
    	quickSort(head, null);
    	return head;
    }
	public void quickSort(ListNode head, ListNode tail) {
		if ((head != tail) && (head.next != tail)) {
			ListNode pivot = partition(head, tail);
			quickSort(head, pivot);
			quickSort(pivot.next, tail);
		}
	}
	// ��ȫ����Ҫָ�����㣬ֻ��Ҫ�ı丳ֵ���ɡ�����tail�Ĳ�������Ҫ�����������ģ��������һ��Ԫ��
	// ��nextָ��λ�ã�һ��Ϊnull�� ��ôд��Ϊ�˼�ͳһ����
	public ListNode partition(ListNode head, ListNode tail) {
		int pivot = head.val;
		ListNode lastLittle = head;
		for (ListNode firstBig = head.next; firstBig != tail; firstBig = firstBig.next) {
			if (firstBig.val <= pivot) {
				lastLittle = lastLittle.next;
				swap(firstBig, lastLittle);
			}
		}
		swap(head, lastLittle);
		return lastLittle;
	}
	
	public void swap(ListNode a, ListNode b) {
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		a.next = b;
		ListQuickSort solution = new ListQuickSort();
		ListNode c = solution.sortList(a);
		System.out.println(c.val);
		System.out.println(c.next.val);
		System.out.println(c.next.next == null);
		
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