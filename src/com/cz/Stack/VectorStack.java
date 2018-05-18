package com.cz.Stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements StackInterface<T>{

	private Vector<T> stack;
	private static final int DEFAULT_CAPACITY = 100;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	
	public VectorStack(int capacity) {
		checkCapacity(capacity);
		stack = new Vector<>(capacity);
		initialized = true;
	}

	private void checkInit() {
		if(!initialized)
			throw new IllegalStateException();
	}

	private void checkCapacity(int capacity) {
		if(capacity>DEFAULT_CAPACITY)
			throw new IllegalStateException();
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		return stack.remove(stack.size()-1);
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return stack.lastElement();
	}

	@Override
	public void push(T anEntry) {
		checkInit();
		stack.add(anEntry);
		
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		stack.clear();
	}

}
