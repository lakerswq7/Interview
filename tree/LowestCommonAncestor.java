package tree;

public class LowestCommonAncestor {

	public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if ((node1 == null) || (node2 == null)) {
			return null;
		}
		return findAncestor(root, node1, node2);
	}
	
	public TreeNode findAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		// 如果根是两个node之一，那么另外一个不管在哪，他们的祖先都是这个root
		// 如果边界，返回null
		if ((root == node1) || (root == node2) || (root == null)) {
			return root;
		}
		
		TreeNode left = findAncestor(root.left, node1, node2);
		TreeNode right = findAncestor(root.right, node1, node2);
		
		// 如果两边都有，则说明祖先就是root
		if ((left != null) && (right != null)) {
			return root;
		}
		// 哪边有返回哪边
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		// 如果两边都没有返回null
		return null;
	}
}
