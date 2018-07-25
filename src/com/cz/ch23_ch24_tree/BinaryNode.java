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
		return 0;
	}
	public int getHeight() {
		return 0;
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
