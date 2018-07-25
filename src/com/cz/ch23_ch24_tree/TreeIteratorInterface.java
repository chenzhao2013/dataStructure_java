package com.cz.ch23_ch24_tree;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
	Iterator<T> getPreorderIterator();
	Iterator<T> getPostorderIterator();
	Iterator<T> getInorderIterator();
	Iterator<T> getLevelorderIterator();
}
