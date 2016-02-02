package tree;

public class DeleteANodeInBinarySearchTree {
	public TreeNode deleteNode(TreeNode root, int val) {
		TreeNode parent = new TreeNode(0);
		// 处理删除节点是root的情况
		parent.left = root;
		findAndDelete(parent, root, val);
		return parent.left;
	}
	
	public void findAndDelete(TreeNode parent, TreeNode root, int val) {
		if (root == null) {
			return;
		}
		if (root.val == val) {
			deleteNode(parent, root);
		} else if (root.val > val) {
			findAndDelete(root, root.left, val);
		} else {
			findAndDelete(root, root.right, val);
		}
	}
	
	public void deleteNode(TreeNode parent, TreeNode root) {
		if (root.left == null) {
			// 如果没有左子树，就直接把右子树赋上去
			if (parent.left == root) {
				parent.left = root.right;
			} else {
				parent.right = root.right;
			}
		} else {
			// 找到左子树中最大的节点作为替换
			TreeNode maxParent = root;
			TreeNode maxNode = root.left;
			while (maxNode.right != null) {
				maxParent = maxNode;
				maxNode = maxNode.right;
			}
			
			// 把替换的节点从链上拿下来
			if (maxNode == maxParent.left) {
				maxParent.left = maxNode.left;
			} else {
				maxParent.right = maxNode.left;
			}
			
			// 替换需要删除的节点
			if(parent.left == root) {
				parent.left = maxNode;
			} else {
				parent.right = maxNode;
			}
			maxNode.left = root.left;
			maxNode.right = root.right;
		}
	}
}
