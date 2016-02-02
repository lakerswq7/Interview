package highfrequency;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * http://www.lintcode.com/en/problem/majority-number-iii/
 */
public class MajorityNumberIII {
	public int majorityNumber(ArrayList<Integer> nums, int k) {
        if ((nums == null) || (nums.size() == 0)) {
            return -1;
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!count.containsKey(num)) {
                if (count.size() < k - 1) {
                    count.put(num, 1);
                } else {
                	// 这里没有办法在遍历iterator的时候同时删除元素，所以先把所有元素复制到ArrayList，再去遍历考察
                    ArrayList<Integer> keys = new ArrayList<Integer>();
                    for (int key : count.keySet()) {
                        keys.add(key);
                    }
                    for (int key : keys) {
                        count.put(key, count.get(key) - 1);
                        if (count.get(key) == 0) {
                            count.remove(key);
                        }
                    }
                }
            } else {
                count.put(num, count.get(num) + 1);
            }
        }
        for (int key : count.keySet()) {
            count.put(key, 0);
        }
        int max = 0;
        int maxNum = 0;
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
                if (count.get(num) > max) {
                    max = count.get(num);
                    maxNum = num;
                }
            }
        }
        return maxNum;
    }
}
