package tree;

import java.util.Iterator;
import java.util.Stack;

public class ImplementIteratorOfBinarySearchTree implements Iterator<TreeNode>{
    private TreeNode cur;
    private Stack<TreeNode> stack;
    private ImplementIteratorOfBinarySearchTree(TreeNode root) {
        cur = root;
        stack = new Stack<TreeNode>();
    }

    public boolean hasNext() {
        return (cur != null) || !stack.empty();
    }
    
    public TreeNode next() {
        TreeNode next = null;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        if (!stack.empty()) {
            cur = stack.pop();
            next = cur;
            cur = cur.right;
        }
        return next;
    }
    public ImplementIteratorOfBinarySearchTree iterator(TreeNode root) {
    	return new ImplementIteratorOfBinarySearchTree(root);
    }
    public void remove() {	
    }
}
