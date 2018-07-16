package com.cz.ch19_ch20;

import java.util.Iterator;

public interface DictionaryInterface<K, V> {

	/**
	 * 添加键值对
	 * @param key
	 * @param value
	 * @return
	 */
	V add(K key, V value);
	/**
	 * 删除键值对
	 * @param key
	 * @return
	 */
	V remove(K key);
	/**
	 * 获取键对应的值
	 * @param key
	 * @return
	 */
	V getValue(K key);
	/**
	 * 是否包含键
	 * @param key
	 * @return
	 */
	boolean contains(K key);
	/**
	 * 获取键的迭代器
	 * @return
	 */
	Iterator<K> getKeyIterator();
	/**
	 * 获取值的迭代器
	 * @return
	 */
	Iterator<V> getValueIterator();
	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 获取字典的长度
	 * @return
	 */
	int getSize();
	/**
	 * 清空字典
	 */
	void clear();
	
}
