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
            // size ʵ���Ͼ���ÿһ���node������ÿ���ڲ�ѭ����ʱ�򱣳ֲ���
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
    
    // �Ƚ�����������ͬ��ʱ��������˼·��
    // �ǵݹ�Ļ�����level order��Ȼ��Ƚϣ�����ע��Ҷ�ӽڵ��nullҲҪ�����ڣ�ֻ����null����Ͳ��ټ�����������
    // �ݹ�Ļ������ȴ���null�������Ȼ���ٿ�root��ֵ�Ƿ�һ����Ȼ���ٿ������ڵ�����������Ĺ�ϵ
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if ((root1 == null) || (root2 == null)) {
            return (root1 == null) && (root2 == null);
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    
    // �������һ��˼·��divide & conquer
    // �ȴ���߽�������Ȼ��ݹ������������Ľ����Ȼ���ٰѽ��������Ӧ��merge����
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // ����Ӧ���ý������������������ǲ���ƽ��ģ� �������Ƕ���
        // ������ -1 ����ʾ����ƽ��ģ�������� -1 �ͱ�ʾ��ƽ���
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
    
    // ����ջ��ģ��DFS
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
