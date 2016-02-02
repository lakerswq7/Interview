package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Test {
    public List<List<Integer>> permuteUnique(int[] num) {
	    List<List<Integer>> rst = new ArrayList<List<Integer>>();
	    if (num == null || num.length == 0) {
	        return rst;
	    }
	    Arrays.sort(num);
	    boolean[] visited = new boolean[num.length];
	    getPermute(rst, new ArrayList<Integer>(), visited, num);
	    return rst;
	}
	public void getPermute(List<List<Integer>> rst, List<Integer> list, boolean[] visited, int[] num) {
	    if (list.size() == num.length) {
	        rst.add(new ArrayList<Integer>(list));
	        return;
	    }
	    for (int i = 0; i < num.length; i++) {
	        if (i != 0 && (num[i] == num[i - 1] && visited[i - 1] == false)) {
	            continue;
	        }
	        if (visited[i] == false) {
	            list.add(num[i]);
	            visited[i] = true;
	            getPermute(rst, list, visited, num);
	            visited[i] = false;
	            list.remove(list.size() - 1);
	        }
	    }
	}
    public static void main(String[] args) {
    }
}
