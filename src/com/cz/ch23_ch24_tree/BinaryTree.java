package com.cz.ch23_ch24_tree;

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>{

	private BinaryNode<T> root;
	
	public BinaryTree() {
		super();
		this.root = null;
	}

	public BinaryTree(T rootData) {
		super();
		this.root = new BinaryNode<>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree,
			BinaryTree<T> rightTree) {
		super();
		privateSetTree(rootData, leftTree, rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if( leftTree !=null && !leftTree.isEmpty())
			root.setLeftNode(leftTree.root);
		if(rightTree != null && !rightTree.isEmpty())
			if(rightTree != leftTree) {
				root.setRightNode(rightTree.root);
			} else {
				root.setRightNode(rightTree.root.copy());
			}
		if(leftTree != null && leftTree != this) {
			leftTree.clear();
		}
		if(rightTree != null && rightTree != this) {
			rightTree.clear();
		}
	}

	@Override
	public T getRootData() {
		if(isEmpty())
			throw new IllegalStateException();
		return root.getData();
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(T rootData) {
		root.setData(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	public void inorderTraverse() {
		inorderTraverse(root);
	}
	public void preorderTraverse() {
		preorderTraverse(root);
	}
	public void postorderTraverse() {
		postorderTraverse(root);
	}
	private void inorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			inorderTraverse(node.getLeftNode());
			System.out.println(node.getData());
			inorderTraverse(node.getRightNode());
		}
	}
	
	private void preorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			System.out.println(node.getData());
			preorderTraverse(node.getLeftNode());
			preorderTraverse(node.getRightNode());
		}
	}
	private void postorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			postorderTraverse(node.getRightNode());
			postorderTraverse(node.getRightNode());
			System.out.println(node.getData());
		}
	}
}
