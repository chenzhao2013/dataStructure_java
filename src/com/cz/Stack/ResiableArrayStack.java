package com.cz.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ResiableArrayStack<T> implements StackInterface<T>{

	private int topIndex;
	private T[] stack;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ResiableArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	public ResiableArrayStack(int capacity) {
		checkCapacity(capacity);
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		this.stack = temp;
		this.topIndex = -1;
		this.initialized = true;
	}

	private void checkCapacity(int capacity) {
		if(capacity>MAX_CAPACITY)
			throw new IllegalStateException("Too large Capacity");
	}
	private void checkInitilization() {
		if(!this.initialized)
			throw new IllegalStateException();
	}
	@Override
	public T pop() {
		checkInitilization();
		if(isEmpty())
			throw new EmptyStackException();
		T result = this.stack[topIndex];
		stack[topIndex--]=null;
		return result;
	}

	
	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return this.stack[topIndex];
	}

	@Override
	public void push(T anEntry) {
		checkInitilization();
		ensureCapacity();
		this.stack[++topIndex] = anEntry;
	}

	private void ensureCapacity() {
		if(topIndex>=this.stack.length-1) {
			int newLength = 2* this.stack.length;
			checkCapacity(newLength);
			Arrays.copyOf(this.stack, newLength);
		}
	}
	@Override
	public boolean isEmpty() {
		return topIndex <= -1 || stack==null;
	}

	@Override
	public void clear() {
		while(topIndex>-1)
			stack[topIndex--]=null;
	}
	public ResiableArrayStack<T> returnThis(){
		return this;
	}
}
