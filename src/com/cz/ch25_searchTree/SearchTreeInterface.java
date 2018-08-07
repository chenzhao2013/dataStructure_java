package com.cz.ch25_searchTree;

import java.util.Iterator;

import com.cz.ch23_ch24_tree.TreeInterface;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>{

	/**
	 * 查找一个项
	 * @param entry
	 * @return
	 */
	boolean contains(T entry);
	/**
	 * 获取一项
	 * @param entry
	 * @return
	 */
	T getEntry(T entry);
	/**
	 * 添加一项
	 * @param entry
	 * @return 重复项放在右子树
	 */
	T add(T entry);
	/**
	 * 移除一项
	 * @param entry
	 * @return
	 */
	T remove(T entry);
	/**
	 * 获取中序遍历器
	 * @return
	 */
	Iterator<T> getInorderIterator();
}
