package com.cz.ch10_queue;

public interface Deque<T> {

	/**
	 * 在队首、队尾添加元素
	 */
	void addToFront();
	void addToBack();
	/**
	 * 在队首、队尾删除元素
	 */
	void removeFront();
	void removeBack();
	/**
	 * 获取队首、队尾元素
	 */
	T getFront();
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
