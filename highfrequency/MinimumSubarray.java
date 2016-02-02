package highfrequency;

import java.util.ArrayList;

public class MinimumSubarray {
    public int minSubArray(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() == 0)) {
            return 0;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            min = Math.min(sum + nums.get(i), min);
            sum = Math.min(sum + nums.get(i), 0);
        }
        return min;
    }
}
