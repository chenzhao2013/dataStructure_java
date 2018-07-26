package com.cz.ch23_ch24_tree;

class BinaryNode<T> {

	private BinaryNode<T> leftNode;
	private T data;
	private BinaryNode<T> rightNode;
	public BinaryNode(BinaryNode<T> leftNode, T data, BinaryNode<T> rightNode) {
		super();
		this.leftNode = leftNode;
		this.data = data;
		this.rightNode = rightNode;
	}
	public BinaryNode(T data) {
		this(null, data, null);
	}
	public BinaryNode() {
		this(null);
	}
	public BinaryNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public boolean hasLeftNode() {
		return leftNode !=null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	public boolean hasRightNode() {
		return rightNode != null;
	}
	public boolean isLeaf() {
		return leftNode == null && rightNode == null;
	}
	public int getNumberOfNodes() {
		return getNo(this);
	}
	private int getNo(BinaryNode<T> binaryNode) {
		//1
//		int no = 0;
//		if(binaryNode!=null)
//			no = 1 + getNo(binaryNode.leftNode)+getNo(binaryNode.rightNode);
//		return no;
		//2 
		int leftNO = 0;
		int rightNO = 0;
		if(leftNode != null) {
			leftNO = leftNode.getNumberOfNodes();
		}
		if(rightNode != null) {
			rightNO = rightNode.getNumberOfNodes();
		}
		return 1 + leftNO + rightNO;
	}
	public int getHeight() {
		return getHeight(this);
	}
	private int getHeight(BinaryNode<T> binaryNode) {
		int height = 0;
		if(binaryNode != null) {
			height = 1+ Math.max(getHeight(binaryNode.leftNode), getHeight(binaryNode.rightNode));
		}
		return height;
	}
	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<>(data);
		if(leftNode!=null)
			newRoot.setLeftNode(leftNode.copy());
		if(rightNode != null) {
			newRoot.setRightNode(rightNode.copy());
		}
		return newRoot;
	}
}
