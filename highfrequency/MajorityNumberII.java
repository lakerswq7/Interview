package highfrequency;

import java.util.ArrayList;

/*
 * http://www.lintcode.com/en/problem/majority-number-ii/
 */
public class MajorityNumberII {
	public int majorityNumber(ArrayList<Integer> nums) {
        if ((nums == null) || (nums.size() == 0)) {
            return -1;
        } 
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int num : nums) {
            if ((count1 != 0) && (num == candidate1)) {
                count1++;
            } else if ((count2 != 0) && (num == candidate2)) {
                count2++;
            } else {
                if (count1 == 0) {
                    candidate1 = num;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        if (count1 == 0) {
            return candidate2;
        }
        if (count2 == 0) {
            return candidate1;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > count2) {
            return candidate1;
        } else {
            return candidate2;
        }
    }
}
