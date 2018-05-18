package com.cz.Package;

import java.util.Arrays;

import com.sun.prism.Image;

public class ResiableBag<T> implements BagInterface<T> {

	private T[] bag;
	private int numberOfEntries;
	private static final int  DEFAULT_CAPACITY = 100;
	private static final int  MAX_CAPACITY = 10000;
	private boolean initialed = false;
	public ResiableBag() {
		this(DEFAULT_CAPACITY);
	}
	public ResiableBag(int size) {
		checkCapacity(size);
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[size];
		this.bag = temp;
		this.numberOfEntries = 0;
		this.initialed = true;
	}
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		if(isFull()) {
			doubleCapacity();
		}
		this.bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}

	
	@Override
	public T remove() {
		checkInitialization();
		T result = null;
		if(this.numberOfEntries > 0) {
			result = this.bag[numberOfEntries-1];
			this.bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = indexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	@Override
	public void clear() {
		checkInitialization();
		while(!isEmpty())
			remove();
	}

	@Override
	public int getFrequenceOf(T anEntry) {
		checkInitialization();
		int count = 0;
		int index = 0;
		while(index < numberOfEntries) {
			if(anEntry.equals(this.bag[index]))
				count++;
			index++;
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return indexOf(anEntry)!=-1;
	}

	@Override
	public T[] toArray() {
		checkInitialization();
		T[] temp = (T[]) new Object[numberOfEntries];
		for(int i=0;i<numberOfEntries;i++) {
			temp[i] = this.bag[i];
		}
		return temp;
	}

	public void checkCapacity(int capacity){
		if(capacity>MAX_CAPACITY)
			throw new IllegalStateException("capacity exeeds of max capacity");
	}
	public boolean isFull() {
		return this.numberOfEntries>=this.bag.length;
	}
	//TODO
	private void doubleCapacity() {
		int size = 2 * this.bag.length;
		checkCapacity(size);
		Arrays.copyOf(this.bag, size);
	}
	public void checkInitialization() {
		if(!this.initialed)
			throw new IllegalStateException("Not Initialized");
	}
	/**
	 * 找到返回index，找不到返回-1
	 * @param anEntry
	 * @return
	 */
	public int indexOf(T anEntry) {
		int index = 0;
		int result = -1;
		boolean found = false;
		while(!found && index<numberOfEntries) {
			if(anEntry.equals(this.bag[numberOfEntries])) {
				result = index;
				found = true;
			}
		}
		return result;
	}
	public T removeEntry(int index) {
		T result = null;
		if(!isEmpty() && index>0) {
			result = this.bag[index];
			this.bag[index] =  this.bag[numberOfEntries-1];
			this.bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		 return result;
	}
}
