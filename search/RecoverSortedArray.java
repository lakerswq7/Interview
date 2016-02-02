package search;

import java.util.ArrayList;

/*
 * http://lintcode.com/zh-cn/problem/recover-rotated-sorted-array/
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */
public class RecoverSortedArray {
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() == 0)) {
            return;
        }
        int pivot = findPivot(nums);
        if (pivot == 0) {
            return;
        } else {
            reverse(nums, 0, pivot - 1);
            reverse(nums, pivot, nums.size() - 1);
            reverse(nums, 0, nums.size() - 1);
        }
    }
    public int findPivot(ArrayList<Integer> nums) {
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (nums.get(mid) > nums.get(low)) {
                low = mid;
            } else if (nums.get(mid) < nums.get(low)) {
                high = mid;
            }
        }
        if (nums.get(low) < nums.get(high)) {
            return 0;
        } else {
            return high;
        }
    }
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	a.add(6); a.add(7); a.add(8); a.add(3); a.add(4); a.add(5);
    	RecoverSortedArray solution = new RecoverSortedArray();
    	solution.recoverRotatedSortedArray(a);
    	for (int m : a) {
    		System.out.println(m);
    	}
    }
}
