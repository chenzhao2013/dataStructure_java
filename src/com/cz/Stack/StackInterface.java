package com.cz.Stack;

public interface StackInterface<T> {
	T pop();
	T peek();
	void push(T anEntry);
	boolean isEmpty();
	void clear(); 
}
