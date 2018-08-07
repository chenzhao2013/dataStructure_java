package com.cz.ch25_searchTree;

import com.cz.ch23_ch24_tree.BinaryTree;
import com.cz.ch23_ch24_tree.BinaryTreeInterface;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setTree(rootEntry);
	}

	@Override
	public boolean contains(T entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T add(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}

}
