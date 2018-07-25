package com.cz.ch23_ch24_tree;

public interface BinaryTreeInterface<T> extends TreeInterface<T>, 
	TreeIteratorInterface<T> {
	void setData();
	void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree);
}
