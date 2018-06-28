package com.cz.ch12_ch13_list;

import java.util.Arrays;

public class ArrayList<T> implements ListInterface<T> {

	public static final int DEFAULT_CAPACITY = 100;
	public static final int MAX_CAPACITY = 10000;
	private T[] list;
	private int numOfEntries;
	private boolean initialized = false;
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayList(int capacity){
		if(capacity<DEFAULT_CAPACITY) {
			capacity = DEFAULT_CAPACITY;
		}else {
			checkCapacity(capacity);			
		}
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[capacity + 1];
		list = tempList;
		numOfEntries = 0;
		initialized = true;
	}
	
	@Override
	public void add(T entry) {
		checkInitialization();
		list[numOfEntries+1] = entry;
		numOfEntries++;
		ensureCapacity();
	}

	
	
	@Override
	public void add(int position, T entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int position, T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[numOfEntries];
		for(int i=0;i<numOfEntries;i++) {
			tempArray[i] = list[i];
		}
		return tempArray;
	}

	@Override
	public boolean contain(T entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	private void checkCapacity(int capacity) {
		if(capacity>MAX_CAPACITY) {
			throw new IllegalStateException("Exceed max capacity");
		}
	}
	private void checkInitialization() {
		if(!initialized) {
			throw new IllegalStateException("no init");
		}
	}
	private void ensureCapacity() {
		int size = this.list.length * 2;
		checkCapacity(size);
		Arrays.copyOf(list, size);
	}
}
