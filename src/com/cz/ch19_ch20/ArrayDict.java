package com.cz.ch19_ch20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.glass.ui.Size;

public class ArrayDict<K, V> implements DictionaryInterface<K, V> {

	private Entry<K, V>[] dictionary;
	private int numOfEntries;
	private boolean initilized;
	private static final int DEFAULT_CAPACITY = 100;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayDict(int capacity) {
		checkCapacity(capacity);
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDict = (Entry<K, V>[])new Entry[capacity];
		dictionary = tempDict;
		numOfEntries = 0;
		initilized = true;
	}

	public ArrayDict() {
		this(DEFAULT_CAPACITY);
	}

	private void checkInitilized() {
		if(!initilized) {
			throw new IllegalStateException();
		}
	}
	/**
	 * 数组长度检测
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		if(capacity>=MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag whose "
					+ "capacity exceeds max_capacity");
		}
	}

	/**
	 * 数组扩容
	 */
	private void ensureCapacity() {
		if(dictionary.length==numOfEntries) {
			int tempSize = dictionary.length * 2;
			checkCapacity(tempSize);
			Arrays.copyOf(dictionary, tempSize);
		}
	}
	/**
	 * 返回给的key的index
	 * 如果不存在，返回numOfEntries
	 * @param key
	 * @return
	 */
	private int locateIndex(K key) {
		int index = numOfEntries;
		for(int i=0; i<numOfEntries;i++) {
			if(key.equals(dictionary[i].getKey())) {
				index = i;
				break;
			}
		}
		return index;
	}
	@Override
	public V add(K key, V value) {
		checkInitilized();
		if(key==null || value==null) {
			throw new IllegalArgumentException();
		}else {
			V result = null;
			int index = locateIndex(key);
			if(index > 0 && index < numOfEntries) {
				result = dictionary[index].getValue();
				dictionary[index].setValue(value);
			} else {
				dictionary[numOfEntries] = new Entry<K, V>(key, value);
				numOfEntries++;
				ensureCapacity();
			}
			return result;
		}
		
	}

	@Override
	public V remove(K key) {
		checkInitilized();
		V result = null;
		int index = locateIndex(key);
		if(index < numOfEntries) {
			result = dictionary[index].getValue();
			dictionary[index] = dictionary[numOfEntries-1];
			dictionary[numOfEntries-1] = null;
			numOfEntries--;
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		V result = null;
		int index = locateIndex(key);
		if(index < numOfEntries) {
			result = dictionary[index].getValue();
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key)!=null;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new Iterator<K>() {

			int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < numOfEntries;
			}

			@Override
			public K next() {
				// TODO Auto-generated method stub
				return dictionary[index++].getKey();
			}
		};
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new Iterator<V>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				return index < numOfEntries;
			}

			@Override
			public V next() {
				return dictionary[index++].getValue();
			}
		};
	}

	@Override
	public boolean isEmpty() {
		return numOfEntries == 0;
	}

	@Override
	public int getSize() {
		return numOfEntries;
	}

	@Override
	public void clear() {
		for(int i=0; i<numOfEntries; i++) {
			dictionary[i] = null;
		}
		HashMap<String, Integer> hashMap = new HashMap<>();
	}

}
