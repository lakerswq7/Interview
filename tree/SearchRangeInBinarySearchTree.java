package tree;

import java.util.ArrayList;
import java.util.Stack;

public class SearchRangeInBinarySearchTree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        if (root == null) {
            return range;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while ((root != null) || (!stack.empty())) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if ((root.val >= k1) && (root.val <= k2)) {
                    range.add(root.val);
                }
                if (root.val > k2) {
                    return range;
                }
                root = root.right;
            }
        }
        return range;
    }
}
