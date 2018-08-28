package com.cz.ch26_heap;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {

	private T[] heap;
	private int lastIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public MaxHeap(int initialCapacity) {
		if(initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		} else {
			checkCapacity(initialCapacity);
		}
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Comparable[initialCapacity + 1];
		heap = temp;
		lastIndex = 0;
		initialized = true;
	}

	public MaxHeap(T[] entries) {
		this(entries.length);
		assert initialized = true;
		for(int index=0; index<lastIndex; index++) {
			heap[index + 1] = entries[index];
		}
		for(int index=lastIndex/2;index>0;index--)
			reheap(index);
	}
	private void checkCapacity(int initialCapacity) {
		if(initialCapacity > MAX_CAPACITY)
			throw new IllegalStateException();
	}
	private void checInitialization() {
		if(!initialized) {
			throw new IllegalStateException();
		}
		
	}
	@Override
	public void add(T entry) {
		checInitialization();
		int newIndex = lastIndex + 1;
		int parIndex = newIndex / 2;
		while(parIndex > 0 && entry.compareTo(heap[parIndex]) > 0) {
			 heap[newIndex] = heap[parIndex];
			 newIndex = parIndex;
			 parIndex = parIndex / 2;
		}
		heap[newIndex] = entry; 
		lastIndex++;
		ensureCapacity();
	}

	private void ensureCapacity() {
		if(lastIndex > heap.length) {
			int newCapacity = 2 * (heap.length - 1);
			checkCapacity(newCapacity);
			heap = Arrays.copyOf(heap, newCapacity);
		}
	}

	@Override
	public T removeMax() {
		checInitialization();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex--];
			reheap(1);
		}
		return root;
	}

	//
	private void reheap(int rootIndex) {
		int leftChildIndex =  2 * rootIndex;
		int maxChildIndex = leftChildIndex;
		int rightChildIndex = leftChildIndex + 1;
		T orphan = heap[rootIndex];
		boolean done = false;
		while(!done && leftChildIndex <= lastIndex) {
			if(heap[rightChildIndex].compareTo(heap[leftChildIndex]) > 0) {
				maxChildIndex = rightChildIndex;
			}
			if(orphan.compareTo(heap[maxChildIndex]) < 0) {
				heap[rootIndex] = heap[maxChildIndex];
				rootIndex = maxChildIndex;
				leftChildIndex = 2 * rootIndex;
			} else {
				done = true;
			}
		}
		heap[rootIndex] = orphan;
	}
	@Override
	public T getMax() {
		checInitialization();
		T root = null;
		if(!isEmpty())
			root = heap[1];
		return root;
	}
	@Override
	public boolean isEmpty() {
		return lastIndex < 1;
	}

	@Override
	public int getSize() {
		return lastIndex;
	}

	@Override
	public void clear() {
		checInitialization();
		while(lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	}

	public static <T extends Comparable<? super T>> void reheap(T[] heap, int rootIndex, int lastIndex) {
		boolean done = false;
		int leftChildIndex= rootIndex * 2 + 1;
		int rightChildIndex = leftChildIndex + 1;
		int largeIndex = leftChildIndex;
		T orphan = heap[rootIndex];
		while(!done && leftChildIndex <= lastIndex) {
			if( heap[rightChildIndex].compareTo(heap[leftChildIndex]) > 0) {
				largeIndex = rightChildIndex;
			}
			if(heap[rootIndex].compareTo(heap[largeIndex]) < 0) {
				heap[rootIndex] = heap[largeIndex];
				rootIndex = largeIndex;
				leftChildIndex = 2 * rootIndex + 1;
			} else
				done = true;
		}
		heap[rootIndex] = orphan;
	}
	public static <T extends Comparable<? super T>> void heapSort(T[] array, int n) {
		for(int rootIndex=n/2-1;rootIndex>=0;rootIndex--) {
			reheap(array, rootIndex, n-1);
		}
		swap(array, 0, n-1);
		for(int lastIndex=n-2;lastIndex>0;lastIndex--) {
			reheap(array, 0, lastIndex);
			swap(array, 0, lastIndex);
		}
	}

	private static <T extends Comparable<? super T>>void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
