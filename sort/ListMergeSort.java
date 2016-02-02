package sort;
// 这个是水中的鱼版本
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
	// 这里需要重新定义类MergeSortList的意思是，我们需要修改这个链表里的head的位置，
	// 通过定义包装类，才能不断修改这个引用的值
    public ListNode mergeSort(int length) {
        if (length == 0) {
        	return null;
        } else if (length == 1) {
            ListNode temp = list;
            // 这里在递归到单个叶子node的时候，每一次都将head向后移，以递归的特性来保证后面
            // 能访问到正确的node，节省了往后倒的时间
            list = list.next;
            // 每到叶子node，就把他从链里面拆出来，等到merge的时候再放回去，这样方便了merge时候的
            // 结束条件的判断
            temp.next = null;
            return temp;
        } else {
            ListNode left = mergeSort(length / 2);
            ListNode right = mergeSort(length - length / 2);
            return merge(left, right);
        }
    }
    public ListNode merge(ListNode left, ListNode right) {
    	// 加入头结点
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
        // 这里已经涵盖了两个都是null的情况，因为如果left和right都是null，则走第一个判断
        // 依然吧right这个null赋过去了，实际上不可能出现这种情况，因为一定有一个先到null，而另外一个不是
        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return head.next;
    }
}
