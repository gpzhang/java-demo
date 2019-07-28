package algorithm.tree.t57;

//找出中序遍历顺序的下一个结点并且返回
public class Solution57 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {// 某一个节点中序遍历时下一个节点是右子树的最左边节点
		if (pNode == null)
			return null;
		// 中序遍历一个节点时，如果有子树存在，该节点后面的子节点一定是该节点的右子树上的节点
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;

		}

		while (pNode.next != null) {// 不是根节点，如果是根节点，并且之前已经判断右子树为空，这返回值为null
			if (pNode == pNode.next.left)
				return pNode.next;
			pNode=pNode.next;
		}

		return null;

	}
}
