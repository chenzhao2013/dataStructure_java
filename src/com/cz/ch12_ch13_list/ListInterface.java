package com.cz.ch12_ch13_list;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;

public interface ListInterface<T> {

	/**
	 * 线性表尾添加数据项
	 * @param entry
	 */
	void add(T entry);
	/**
	 * 给定位置添加数据项
	 * @param position
	 * @param entry
	 */
	void add (int position, T entry);
	/**
	 * 删除给定位置数据
	 * @param position
	 * @return
	 */
	T remove(int position);
	/**
	 * 清空线性表
	 */
	void clear();
	/**
	 * 替换给定位置数据
	 * @param position
	 * @param entry
	 * @return
	 */
	T replace(int position, T entry);
	/**
	 * 获取给定位置数据
	 * @param position
	 * @return
	 */
	T getEntry(int position);
	/**
	 * 转换成数组
	 * @return
	 */
	T[] toArray();
	/**
	 * 是否包含给定数据项
	 * @param entry
	 * @return
	 */
	boolean contain(T entry);
	/**
	 * 获取线性表长度
	 * @return
	 */
	int getLength();
	/**
	 * 判断是否空
	 * @return
	 */
	boolean isEmpty();
}
