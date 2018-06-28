package com.cz.ch12_ch13_list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.ls.LSInput;

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
		list[numOfEntries] = entry;
		numOfEntries++;
		ensureCapacity();
	}

	
	
	@Override
	public void add(int position, T entry) {
		checkInitialization();
		if(position>=0 && position<=numOfEntries) {
			if(position <= numOfEntries) {
				makeRoom(position);
			}
			list[position] = entry;
			numOfEntries++;
			ensureCapacity();
		}else {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
	}

	private void makeRoom(int position) {
		assert position>=0 && position <= numOfEntries;
		for(int i=numOfEntries-1;i>=position;i--) {
			list[i+1] = list[i];
		}
	}
	@Override
	public T remove(int position) {
		checkInitialization();
		if(position>=0 && position <numOfEntries) {
			T result = list[position];
			if(position < numOfEntries-1) {
				removeGap(position);
			}
			numOfEntries--;
			list[numOfEntries]=null;//原來位置置空
			return result;
		}else {
			throw new IndexOutOfBoundsException("ILLEGAL INDEX");
		}
	}

	private void removeGap(int position) {
		if(position>=0 && position < numOfEntries-1) {
			for(int i=position;i<numOfEntries-1;i++) {
				list[i] = list[i+1];
			}
		}
	}
	@Override
	public void clear() {
		checkInitialization();
		while(!isEmpty()) {
			remove(numOfEntries-1);
		}
	}

	@Override
	public T replace(int position, T entry) {
		if(position>=0 && position < numOfEntries) {
			assert !isEmpty();
			T origin = list[position];
			list[position] = entry;
			return origin;
		}else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T getEntry(int position) {
		checkInitialization();
		if(position>=0 && position < numOfEntries) {
			return list[position];
		}else {
			throw new IndexOutOfBoundsException();
		}
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
		checkInitialization();
		boolean found = false;
		int index = 0;
		while(!found && index < numOfEntries) {
			if(entry.equals(list[index])) {
				found = true;
			}
			index++;
		}
		return found;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return numOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numOfEntries==0;
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
		if(this.numOfEntries>=this.list.length) {
			int size = this.list.length * 2;
			checkCapacity(size);
			Arrays.copyOf(list, size);
		}
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			int current = 0;
			//boolean hasNext = true;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current<numOfEntries;
			}

			@Override
			public T next() {
				if(hasNext()) {
					return list[current++];
				}else {
					throw new NoSuchElementException();
				}
			}
		};
	}
}
