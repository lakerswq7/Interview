package mianjing.linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 就是NestedInteger depth sum那道题，需要把depth反过来乘
 */
public class ReverseDepthSum {
	// recursion 
	public int getReverseSum(List<NestedInteger> nestedList) {
		int depth = getDepth(nestedList, 1);
		return getSum(nestedList, depth);
	}
	private int getSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				sum += depth * n.getInteger();
			} else {
				sum += getSum(n.getList(), depth - 1);
			}
		}
		return sum;
	}
	private int getDepth(List<NestedInteger> nestedList, int depth) {
		int max = depth;
		for (NestedInteger n : nestedList) {
			if (!n.isInteger()) {
				max = Math.max(max, getDepth(n.getList(), depth + 1));
			}
		}
		return max;
	}
	// iteration
	public int getReverseSum2(List<NestedInteger> nestedList) {
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
		int prev = 0, sum = 0;
		for (NestedInteger n : nestedList){
			if (n.isInteger()) {
				prev += n.getInteger();
				sum += n.getInteger();
			} else {
				queue.offer(n);
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			sum += prev;
			for (int i = 0; i < size; i++) {
				NestedInteger cur =  queue.poll();
				for (NestedInteger n : cur.getList()) {
					if (n.isInteger()) {
						prev += n.getInteger();
						sum += n.getInteger();
					} else {
						queue.offer(n);
					}
				}
			}
		}
		return sum;
	}
    public interface NestedInteger {
    	// @return true if this NestedInteger holds a single integer, rather than a nested list.
    	public boolean isInteger();
    	
    	// @return the single integer that this NestedInteger holds, if it holds a single integer
    	// Return null if this NestedInteger holds a nested list
    	public Integer getInteger();
    	
    	// @return the nested list that this NestedInteger holds, if it holds a nested list
    	// Return null if this NestedInteger holds a single integer
    	public List<NestedInteger> getList();
    }
}
