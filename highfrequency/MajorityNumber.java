package highfrequency;

import java.util.ArrayList;

/*
 * http://www.lintcode.com/en/problem/majority-number/
 */
public class MajorityNumber {
    public int majorityNumber(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() == 0)) {
            return -1;
        }
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
