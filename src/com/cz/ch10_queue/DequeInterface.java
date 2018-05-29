package com.cz.ch10_queue;

public interface DequeInterface<T> {

	/**
	 * 在队首添加元素
	 */
	void addToFront(T entry);
	/**
	 * 在队尾添加元素
	 */
	void addToBack(T entry);
	/**
	 * 在队首删除元素
	 */
	void removeFront();
	/**
	 * 在队尾删除元素
	 */
	void removeBack();
	/**
	 * 获取队首元素
	 */
	T getFront();
	/**
	 * 获取队尾元素
	 */
	T getBack();
	/**
	 * 判断是否为空
	 */
	boolean isEmpty();
	/**
	 * 清空队列
	 */
	void clear();
}
