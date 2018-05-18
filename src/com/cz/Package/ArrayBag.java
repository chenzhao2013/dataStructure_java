package com.cz.Package;

public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	//默认长度构造方法
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	// 用户自定义长度构造方法
	public ArrayBag(int capacity) {
		if(capacity <= MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[capacity];
			bag = tempBag;
			this.numberOfEntries = 0;
			this.initialized = true;
		} else {
			throw new IllegalStateException("Attempt to create a bag whose "
					+ "capacity exceeds max_capacity");
		}
	}

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries==0;
	}

	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		boolean result = true;
		if(isArrayFull()) {
			result = false;
		} else {
			bag[numberOfEntries++] = newEntry;
		}
		return result;
	}

	@Override
	public T remove() {
		checkInitialization();
		T entry = null;//bag[numberOfEntries];
		if(numberOfEntries > 0) {
			entry = bag[numberOfEntries];
			bag[numberOfEntries] = null;
			numberOfEntries--;
		}
		return entry;
	}

	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		//result = null;//bag[numberOfEntries];
		int index = indexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	@Override
	public void clear() {
		while(!isEmpty())
			remove();
	}

	@Override
	public int getFrequenceOf(T anEntry) {
		checkInitialization();
		int result = 0;
		for(int i = 0;i < numberOfEntries; i++) {
			if(anEntry.equals(bag[i]))
				result++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return indexOf(anEntry) > -1;
	}

	@Override
	public T[] toArray() {
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for(int i=0; i<numberOfEntries; i++) {
			result[i] = bag[i];
		}
		return result;
		/**
		 * error code
		 * 直接返回bag引用，外界可以直接修改数据内容，
		 * 导致不必要的麻烦
		 */
		//return bag;
		
	}

	public boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}
	public void checkInitialization() {
		/**
		 * 这里抛出了运行时异常，因此方法名后面不需要声明抛出异常
		 * 如果方法内抛出的不是运行时异常，方法名后面必须声明抛出异常
		 */
		if(!initialized) 
			throw new SecurityException("Array bag is not "
					+ "initialized properly");
	}
	/**
	 * 查询某项出现的index，不存在返回-1
	 * @param anEntry
	 * @return
	 */
	public int indexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && index < numberOfEntries) {
			if(anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	public T removeEntry(int index) {
		T result = null;
		if(!isEmpty() && index > 0) {
			result = bag[index];
			bag[index] = bag[numberOfEntries-1];
			bag[numberOfEntries] = null;
			numberOfEntries--;
		}
		return result;
	}
}
