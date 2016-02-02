package sort;
// �����ˮ�е���汾
public class ListMergeSort {
	private ListNode list;
	public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        list = head;
        return mergeSort(len);
    }
	// ������Ҫ���¶�����MergeSortList����˼�ǣ�������Ҫ�޸�����������head��λ�ã�
	// ͨ�������װ�࣬���ܲ����޸�������õ�ֵ
    public ListNode mergeSort(int length) {
        if (length == 0) {
        	return null;
        } else if (length == 1) {
            ListNode temp = list;
            // �����ڵݹ鵽����Ҷ��node��ʱ��ÿһ�ζ���head����ƣ��Եݹ����������֤����
            // �ܷ��ʵ���ȷ��node����ʡ�����󵹵�ʱ��
            list = list.next;
            // ÿ��Ҷ��node���Ͱ������������������ȵ�merge��ʱ���ٷŻ�ȥ������������mergeʱ���
            // �����������ж�
            temp.next = null;
            return temp;
        } else {
            ListNode left = mergeSort(length / 2);
            ListNode right = mergeSort(length - length / 2);
            return merge(left, right);
        }
    }
    public ListNode merge(ListNode left, ListNode right) {
    	// ����ͷ���
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while ((left != null) && (right != null)) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        // �����Ѿ���������������null���������Ϊ���left��right����null�����ߵ�һ���ж�
        // ��Ȼ��right���null����ȥ�ˣ�ʵ���ϲ����ܳ��������������Ϊһ����һ���ȵ�null��������һ������
        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return head.next;
    }
}
