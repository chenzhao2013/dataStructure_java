package com.cz.ch10_queue;

public class ArrayQueue<T> implements QueueInterface<T> {

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	private static final int DEFAULT_CAPACITY = 50;
	
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueue(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
		
	}
	private void checkCapacity(int initialCapacity) {
		if(initialCapacity > MAX_CAPACITY)
			throw new IllegalStateException("Too large capacity");
		
	}
	private void checkInitilization() {
		if(!this.initialized)
			throw new IllegalStateException();
	}
	@Override
	public void enqueue(T entry) {
		checkInitilization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = entry;
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex+1)% queue.length;
			return front;
		}
	}

	@Override
	public T getFront() {
		checkInitilization();
		if(isEmpty())
			throw new EmptyQueueException();
		else {
			return queue[backIndex];
		}
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == (backIndex + 1) % queue.length;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			dequeue();
	}
	private void ensureCapacity() {
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = oldSize * 2;
			checkCapacity(newSize);
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int i=0; i< oldSize-1; i++) {
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = oldSize;
			backIndex = oldSize - 2;
		}
	}
}
