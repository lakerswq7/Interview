package tree;

public class DeleteANodeInBinarySearchTree {
	public TreeNode deleteNode(TreeNode root, int val) {
		TreeNode parent = new TreeNode(0);
		// ����ɾ���ڵ���root�����
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
			// ���û������������ֱ�Ӱ�����������ȥ
			if (parent.left == root) {
				parent.left = root.right;
			} else {
				parent.right = root.right;
			}
		} else {
			// �ҵ������������Ľڵ���Ϊ�滻
			TreeNode maxParent = root;
			TreeNode maxNode = root.left;
			while (maxNode.right != null) {
				maxParent = maxNode;
				maxNode = maxNode.right;
			}
			
			// ���滻�Ľڵ������������
			if (maxNode == maxParent.left) {
				maxParent.left = maxNode.left;
			} else {
				maxParent.right = maxNode.left;
			}
			
			// �滻��Ҫɾ���Ľڵ�
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
