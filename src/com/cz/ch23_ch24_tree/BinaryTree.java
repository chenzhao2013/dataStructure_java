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
		// TODO Auto-generated method stub
		return root.getData();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
	public void setData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}

}
