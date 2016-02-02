package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	// BFS
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
    
    // 比较两个树的异同的时候都是两种思路：
    // 非递归的话就用level order，然后比较，这里注意叶子节点的null也要算在内，只不过null本身就不再加左右子树了
    // 递归的话就是先处理null的情况，然后再看root的值是否一样，然后再看两个节点的左右子树的关系
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if ((root1 == null) || (root2 == null)) {
            return (root1 == null) && (root2 == null);
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    
    // 处理的另一大思路是divide & conquer
    // 先处理边界条件，然后递归算左右子树的结果，然后再把结果进行相应的merge处理
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 本来应该用结果类来存两个结果：是不是平衡的， 最大深度是多少
        // 可以用 -1 来表示不是平衡的，如果不是 -1 就表示是平衡的
        if ((left == -1) || (right == -1) || (Math.abs(left - right) > 1)) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
    
    // DFS
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // do something with root
        traverse(root.left);
        // do something with root
        traverse(root.right);
        // do something with root
    }
    
    // 利用栈来模拟DFS
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
