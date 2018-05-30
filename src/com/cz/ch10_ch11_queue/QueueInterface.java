package com.cz.ch10_ch11_queue;

public interface QueueInterface<T> {

	/**
	 * 入队
	 * @param entry
	 */
	void enqueue(T entry);
	/**
	 * 出队
	 * @throws EmptyQueueException
	 * @return
	 */
	T dequeue();
	/**
	 * 获取队首的项
	 * @throws EmptyQueueException
	 * @return
	 */
	T getFront();
	/**
	 * 判断队列是否为空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 清空队列
	 */
	void clear();
}
