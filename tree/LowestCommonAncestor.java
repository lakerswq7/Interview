package tree;

public class LowestCommonAncestor {

	public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if ((node1 == null) || (node2 == null)) {
			return null;
		}
		return findAncestor(root, node1, node2);
	}
	
	public TreeNode findAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		// �����������node֮һ����ô����һ���������ģ����ǵ����ȶ������root
		// ����߽磬����null
		if ((root == node1) || (root == node2) || (root == null)) {
			return root;
		}
		
		TreeNode left = findAncestor(root.left, node1, node2);
		TreeNode right = findAncestor(root.right, node1, node2);
		
		// ������߶��У���˵�����Ⱦ���root
		if ((left != null) && (right != null)) {
			return root;
		}
		// �ı��з����ı�
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		// ������߶�û�з���null
		return null;
	}
}
