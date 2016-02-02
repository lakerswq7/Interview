package tree;

public class InsertANodeInBinarySearchTree {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }
        TreeNode last = null;
        TreeNode temp = root;
        while (temp != null) {
            last = temp;
            if (temp.val > node.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (last.val > node.val) {
            last.left = node;
        } else {
            last.right = node;
        }
        return root;
    }
}
