package com.cz.ch26_heap;

public interface MaxHeapInterface<T extends Comparable<? super T>> {
	void add(T entry);
	T removeMax();
	T getMax();
	boolean isEmpty();
	int getSize();
	void clear();
}
