package Day09;

public class No55DepthOfBinaryTreeNode {
	/*
	 * 面试题55：二叉树的深度
	 * 题目一：二叉树的深度
	 * 输入一棵二叉树的根节点，求树的深度。
	 * 从根节点到叶节点依次经过的节点（含根、叶节点）
	 * 形成树的一条路径，最长路径的长度为树的深度。
	 * 
	 * 
	 * 思路：计算树的深度有以下几种几种情况：
	 * 1>若只有根节点，则深度为1
	 * 2>若根节点只有右子树，则根节点深度=右子树深度+1
	 * 3>若根节点只有左子树，则根节点深度=左子树深度+1
	 * 4>若根节点有左、右子树，则根节点深度=max{左子树深度，右子树深度} +1
	 * 
	 * */
	static class BinaryTreeNode{
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(int val){
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		No55DepthOfBinaryTreeNode f = new No55DepthOfBinaryTreeNode();
		BinaryTreeNode root1 = new BinaryTreeNode(5);
		BinaryTreeNode one = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(7);
		BinaryTreeNode three = new BinaryTreeNode(2);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(6);
		BinaryTreeNode six = new BinaryTreeNode(8);
		
		root1.left = one;
		root1.right = two;
		one.left = three;
		one.right = four;
		two.left = null;
		two.right = six;
		three.left = null;
		three.right = null;
		four.left = five;
		four.right = null;
		five.left = null;
		five.right = null;
		six.left = null;
		six.right = null;
		
		System.out.println("二叉树的深度为："+f.TreeDepth(root1));
		
	}
 
	//因为是从为null的节点开始计数，叶节点是由为空的节点+1的来，以此类推
	private int TreeDepth(BinaryTreeNode root1) {
		// TODO Auto-generated method stub
		if(root1 == null)
			return 0;
		
		int left = TreeDepth(root1.left);
		int right =TreeDepth(root1.right);
		return (left > right)?(left+1):(right+1);
	}


}
