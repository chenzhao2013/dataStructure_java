package com.cz.ch23_ch24_tree;

public interface TreeInterface<T> {
	T getRootData();
	int getHeight();
	int getNumberOfNodes();
	boolean isEmpty();
	void clear();
}
