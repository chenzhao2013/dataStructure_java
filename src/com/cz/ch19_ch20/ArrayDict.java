package com.cz.ch19_ch20;

import java.util.Arrays;
import java.util.Iterator;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
