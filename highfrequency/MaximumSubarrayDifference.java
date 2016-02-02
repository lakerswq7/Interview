package highfrequency;

import java.util.ArrayList;

public class MaximumSubarrayDifference {
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() < 2)) {
            return 0;
        }
        int size = nums.size();
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMin = new int[size];
        
        int sumMax = Math.max(nums.get(0), 0);
        int sumMin = Math.min(nums.get(0), 0);
        leftMax[0] = leftMin[0] = nums.get(0);
        rightMax[size - 1] = rightMin[size - 1] = nums.get(size - 1);
        
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], sumMax + nums.get(i));
            sumMax = Math.max(sumMax + nums.get(i), 0);
            leftMin[i] = Math.min(leftMin[i - 1], sumMin + nums.get(i));
            sumMin = Math.min(sumMin + nums.get(i), 0);
        }
        sumMax = Math.max(nums.get(size - 1), 0);
        sumMin = Math.min(nums.get(size - 1), 0);
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], sumMax + nums.get(i));
            sumMax = Math.max(sumMax + nums.get(i), 0);
            rightMin[i] = Math.min(rightMin[i + 1], sumMin + nums.get(i));
            sumMin = Math.min(sumMin + nums.get(i), 0);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(rightMax[i + 1]- leftMin[i])));
        }
        return max;
        
    }
}
