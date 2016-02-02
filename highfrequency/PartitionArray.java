package highfrequency;

import java.util.ArrayList;

/*
 * http://www.lintcode.com/en/problem/partition-array/
 */
public class PartitionArray {
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    if ((nums == null) || (nums.size() == 0)) {
	        return 0;
	    }
	    int index = 0;
	    int temp;
	    for (int i = 0; i < nums.size(); i++) {
	        if (nums.get(i) < k) {
	            temp = nums.get(i);
	            nums.set(i, nums.get(index));
	            nums.set(index, temp);
	            index++;
	        }
	    }
	    return index;
    }
}
