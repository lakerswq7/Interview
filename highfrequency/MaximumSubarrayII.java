package highfrequency;

import java.util.ArrayList;

/*
 * http://www.lintcode.com/en/problem/maximum-subarray-ii/
 */
public class MaximumSubarrayII {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() == 0)) {
            return 0;
        }
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        int sum = Math.max(nums.get(0), 0);
        left[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            left[i] = Math.max(left[i - 1], sum + nums.get(i));
            sum = Math.max(nums.get(i) + sum, 0);
        }
        sum = Math.max(nums.get(nums.size() - 1), 0);
        right[nums.size() - 1] = nums.get(nums.size() - 1);
        for (int i = nums.size() - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], sum + nums.get(i));
            sum = Math.max(nums.get(i) + sum, 0);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(max, right[i + 1] + left[i]);
        }
        return max;
    }
}
