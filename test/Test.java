package test;

import java.util.*;


public class Test {
	static int[] iX = {-1, 1, 0, 0};
    static int[] iY = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] input = initiale(matrix);
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int round = 0;
        while (queue.size() != 0) {
            round++;
            int size = queue.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
            	Pair p = queue.poll();

	            for (int k = 0; k < 4; k++) {
	                int newX = p.x + iX[k];
	                int newY = p.y + iY[k];
	                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
	                    if (matrix[p.x][p.y] < matrix[newX][newY]) {
	                        input[newX][newY]--;
	                        if (input[newX][newY] == 0) {
	                            queue.offer(new Pair(newX, newY));
	                        }
	                    }
	                }
	            }
            }
        }
        return round;
    }
    static int[][] initiale(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newX = i + iX[k];
                    int newY = j + iY[k];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (matrix[i][j] > matrix[newX][newY]) {
                            input[i][j]++;
                        }
                    }   
                }
            }
        }
        return input;
    }
    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
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
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        
        int n = s1.length();
        int[][][] cache = new int[n][n][n];
        System.out.println(n);
        return isScrambleHelper(s1, s2, 0, 0, n, cache);
    }
    private boolean isScrambleHelper(String s1, String s2, int i, int j, int k, int[][][] cache) {
        if (cache[i][j][k - 1] == 2) {
            return true;
        } else if (cache[i][j][k - 1] == 1) {
            return false;
        }
        if (k == 1) {
        	System.out.println(2);
            if (s1.charAt(i) == s2.charAt(j)) {
                cache[i][j][k - 1] = 2;
                return true;
            } else {
                cache[i][j][k - 1] = 1;
                return false;
            }
        }
        for (int m = 1; m < k; m++) {
            if ((isScrambleHelper(s1, s2, i, j, m, cache) && isScrambleHelper(s1, s2, i + m, j + m, k - m, cache))
            || (isScrambleHelper(s1, s2, i, j + k - m, m, cache) && isScrambleHelper(s1, s2, i + m, j, k - m, cache))) {
                cache[i][j][k - 1] = 2;
                return true;
            }
        }
        cache[i][j][k - 1] = 1;
        return false;
    }
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        TreeLinkNode parent;
        TreeLinkNode cur = first;
        while (first != null) {
            parent = first;
            first = null;
            while (parent != null) {
                if (parent.left != null) {
                    first = parent.left;
                    cur = first;
                    if (parent.right != null) {
                        first.next = parent.right;
                        cur = parent.left;
                    }
                    break;
                }
                if (parent.right != null) {
                    first = parent.right;
                    cur = first;
                    break;
                }
                parent = parent.next;
            }
            if (first == null) {
                return;
            }
//            System.out.println(first.val);
            while (parent.next != null) {
            	
                parent = parent.next;
                if (parent.left != null) {
                    cur.next = parent.left;
                    cur = cur.next;
//                    System.out.println(cur.val);
                }
                if (parent.right != null) {
                	System.out.println(cur.val);
                    cur.next = parent.right;
                    System.out.println(cur.next.val);
                    cur = cur.next;
                }
            }
        }
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();
            // size 实际上就是每一层的node数，在每次内层循环的时候保持不变
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) return null;
        if (root.val < value) root.right = removeNode(root.right, value);
        else if (root.val > value) root.left = removeNode(root.left, value);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.left == null){
                root = root.right;
            } else if (root.right == null){
                root = root.left;
            } else {
                TreeNode rightMin = findMin(root.right);
                root.val = rightMin.val;
                root.right = removeNode(root.right, root.val);
            }
        }
        return root;
    }
    public TreeNode findMin(TreeNode node){
        if (node.left == null) return node;
        return findMin(node.left);
    }
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPal(s, i)) {
                return buildPal(s, i);
            }
        }
        return null;
    }
    private String buildPal(String s, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > index; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
    private boolean isPal(String s, int index) {
        int start = 0;
        int end = index;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int calculate(String s) {
        int result = 0, temp = 0, num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || c == ')') {
                if (c == ')') {
                    num = result + temp;
                    temp = stack.pop();
                    result = stack.pop();
                    sign = operator.pop();
                } else {
                    num = num * 10 + c - '0';
                }
                
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1)) || c == ')') {
                    switch (sign) {
                        case '+': result += temp; temp = num; break;
                        case '-': result += temp; temp = -num; break;
                        case '*': temp *= num; break;
                        case '/': temp /= num; break;
                    }
                    num = 0;
                }
            } else if (c == ' ') {
                continue;
            } else if (c == '(') {
                stack.push(result);
                stack.push(temp);
                operator.push(sign);
                result = 0;
                temp = 0;
                sign = '+';
            } else {
                sign = c;
            }
        }
        result += temp;
        return result;
    }
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return rst;
        }
        dfs(rst, "", num, 0, 0, 0, target);
        return rst;
    }
    private void dfs(List<String> rst, String path, String num, int pos, long result, long temp, int target) {
        if (outOfRange(temp) || outOfRange(result)) {
            return;
        }
        if (pos == num.length()) {
            result += temp;
            if (result == target) {
                rst.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (outOfRange(cur)) {
                return;
            }
            if (pos == 0) {
                dfs(rst, path + cur, num, i + 1, 0, cur, target);
            } else {
                dfs(rst, path + "+" + cur, num, i + 1, result + temp, cur, target);
                dfs(rst, path + "-" + cur, num, i + 1, result + temp, -cur, target);
                dfs(rst, path + "*" + cur, num, i + 1, result, temp * cur, target);
            }
            if (num.charAt(pos) == '0') {
                break;
            }
        }
    }
    private boolean outOfRange(long num) {
        return num > Integer.MAX_VALUE || num < Integer.MIN_VALUE;
    }
    public boolean isAdditiveNumber(String num) {
        return isAdditive(new ArrayList<Long>(), num, 0);
    }
    private boolean isAdditive(ArrayList<Long> list, String num, int pos) {
        if (pos == num.length()) {
            return true;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                return false;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (outOfRange(cur)) {
                return false;
            }
            if (list.size() >= 2) {
                if (list.get(list.size() - 1) + list.get(list.size() - 2) == cur) {
                    list.add(cur);
                    if (isAdditive(list, num, i + 1)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(cur);
                if (isAdditive(list, num, i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] rst = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i > m || k - i > n) {
                continue;
            }
            int[] array1 = getK(nums1, i);
            int[] array2 = getK(nums2, k - i);
            int[] candidate = merge(array1, array2);
            if (isGreater(candidate, 0, rst, 0)) {
                rst = candidate;
            }
        }
        return rst;
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < nums1.length || i2 < nums2.length) {
            if (isGreater(nums1, i1, nums2, i2)) {
                ans[i++] = nums1[i1++];
            } else {
                ans[i++] = nums2[i2++];
            }
        }
        return ans;
    }
    private boolean isGreater(int[] nums1, int start1, int[] nums2, int start2) {
        while(start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] > nums2[start2]) {
                return true;
            } else if (nums1[start1] < nums2[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return start1 != nums1.length;
    }
    private int[] getK(int[] nums, int k) {
        int[] ans = new int[k];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pos != 0 && pos - 1 + nums.length - i >= k && ans[pos - 1] < nums[i]) {
                pos--;
            }
            if (pos < k) {
                ans[pos++] = nums[i];
            }
        }
        return ans;
    }
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if ((Math.log10(n) % Math.log10(3)) == 0) {
            return true;
        }
        System.out.println(Math.log10(n) / Math.log10(3));
        return false;
    }
    public int minArea(char[][] image, int x, int y) {
        int minRow = bs(image, 0, x, true, true);
        int maxRow = bs(image, x, image.length - 1, true, false);
        int minCol = bs(image, 0, y, false, true);
        int maxCol = bs(image, y, image[0].length - 1, false, false);
//        System.out.println(minRow);
//        System.out.println(maxRow);
//        System.out.println(minCol);
//        System.out.println(maxCol);
        return (maxRow - minRow) * (maxCol - minCol);
    }
    private boolean hasOne(char[][] image, int line, boolean searchRow) {
        for (int i = 0; i < (searchRow ? image[0].length : image.length); i++) {
            if ((searchRow ? image[line][i] : image[i][line]) == '1') {
                return true;
            }
        }
        return false;
    }
    private int bs(char[][] image, int low, int high, boolean searchRow, boolean searchMin) {
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (hasOne(image, mid, searchRow)) {
                if (searchMin) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (searchMin) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return low;
    }
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<String>();
        getAbbr(rst, "", word, 0, false);
        return rst;
    }
    private void getAbbr(List<String> rst, String cur, String word, int pos, boolean preNum) {
        if (pos == word.length()) {
            rst.add(cur);
            return;
        }
        for (int i = pos; i < word.length(); i++) {
            getAbbr(rst, cur + word.substring(pos, i + 1), word, i + 1, false);
            if (!preNum) {
                getAbbr(rst, cur + (i - pos + 1), word, i + 1, true);
            }
        }
    }
    public String reverseVowels(String s) {
        String vowels = "aeiou";
        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;
        while (start < end) {
            while (!vowels.contains(String.valueOf(array[start])) && start < end) {
                start++;
            }
            while (!vowels.contains(String.valueOf(array[end])) && start < end) {
                end--;
            }
            swap(array, start, end);
            start++;
            end--;
        }
        return String.valueOf(array);
    }
    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void main(String[] args) {
    	Test sol = new Test();
    	System.out.println(sol.reverseVowels("hello"));
//    	System.out.println(1 << -30);
//    	String a = "2,2.3";
//    	for (String c : a.split(",")) {
//    		System.out.println(c);
//    	}
//    	int d = 1;
//    	System.out.println(d);
//    	String s = "AW,E";
//    	s = s.toLowerCase();
//    	System.out.println(s);
//    	Test sol = new Test();
//    	System.out.println(sol.shortestPalindrome("aaaadaaaaaaaa"));
//    	TreeNode root = new TreeNode(2);
//    	root.left = new TreeNode(1);
//    	root.right = new TreeNode(3);
//    	sol.removeNode(root, 2);
//    	for (List<Integer> l : sol.levelOrder(root)) {
//    		for (Integer l1 : l) {
//    			System.out.println(l1);
//    		}
//    	}
    	
    }
}
class TreeLinkNode {
	int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
