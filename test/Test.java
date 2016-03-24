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
    public static void main(String[] args) {
    	Test sol = new Test();
    	String s = "3 * (2 * 4) - (3 / 2) * (3 * 6 / (5 - 2))";
    	System.out.println(sol.calculate(s));
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
