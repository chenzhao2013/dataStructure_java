package com.cz.ch25_searchTree;

import com.cz.ch23_ch24_tree.BinaryNode;
import com.cz.ch23_ch24_tree.BinaryTree;
import com.cz.ch23_ch24_tree.BinaryTreeInterface;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));//不能使用setRootData,因为默认构造方法使得root为空指针
	}

	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}
	
	private T findEntry(BinaryNode<T> root, T entry) {
		T result = null;
		if(root != null) {
			T rootEntry = root.getData();
			if(entry.equals(rootEntry)) {
				result = entry;
			} else if(entry.compareTo(rootEntry) < 0) {
				result = findEntry(root.getLeftNode(), entry);
			} else {
				result = findEntry(root.getRightNode(), entry);
			}
		}
		return result;
	}
	
	@Override
	public T add(T entry) {
		if(isEmpty()) {
			setRootNode(new BinaryNode<>(entry));
			return null;
		} else {
			return addEntry(getRootNode(), entry);
		}
	}

	//add 递归版
	private T addEntry(BinaryNode<T> rootNode, T entry) {
		assert rootNode != null;
		T result = null;
		int compare = entry.compareTo(rootNode.getData());
		if(compare == 0) {
			result = rootNode.getData();
			rootNode.setData(entry);
		} else if (compare < 0) {
			if(rootNode.hasLeftNode()) {
				result = addEntry(rootNode.getLeftNode(), entry);
			} else {
				rootNode.setLeftNode(new BinaryNode<>(entry));
			}
		} else {
			if(rootNode.hasRightNode()) {
				result = addEntry(rootNode.getRightNode(), entry);
			} else {
				rootNode.setRightNode(new BinaryNode<>(entry));
			}
		}
		return result;
	}
	
	//add 迭代版
	private T addEntryIte(T entry){
		T result = null;
		BinaryNode<T> currnetNode = getRootNode();
		boolean found = false;
		while(!found) {
			int compare = entry.compareTo(currnetNode.getData());
			if(compare == 0) {
				found = true;
				result = getRootData();
				setRootData(entry);
			} else if (compare < 0) {
				if(currnetNode.hasLeftNode()) {
					currnetNode = currnetNode.getLeftNode();
				} else {
					found = true;
					currnetNode.setLeftNode(new BinaryNode<>(entry));
				}
			} else {
				if(currnetNode.hasRightNode()) {
					currnetNode = currnetNode.getRightNode();
				} else {
					found = true;
					currnetNode.setRightNode(new BinaryNode<>(entry));
				}
			}
		}
		return result;
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
