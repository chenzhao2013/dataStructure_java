package com.cz.ch12_ch13_list;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class LList<T> implements ListInterface<T> {

	private Node<T> firstNode;
	private int numOfEntries;
	public LList() {
		initialDataField();
	}
	private void initialDataField() {
		firstNode = null;
		numOfEntries = 0;
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> current = firstNode;
			@Override
			public boolean hasNext() {
				return current!=null;
			}
			@Override
			public T next() {
				if(hasNext()) {
					T data = current.getData();
					current = current.getNext();
					return data;
				}else {
					throw new NoSuchElementException();
				}
			}
		};
	}

	@Override
	public void add(T entry) {
		Node<T> newNode =new Node<T>(entry);
		if(isEmpty()) {
			firstNode = newNode;
		} else {
			Node<T> lastNode = getNodeAt(numOfEntries);
			lastNode.setNext(newNode);
		}
		numOfEntries++;
	}

	@Override
	public void add(int position, T entry) {
		if((position>=1) && position<=numOfEntries+1) {
			Node<T> newNode = new Node<>(entry);
			if(position==1) {
				newNode.setNext(firstNode);
				firstNode = newNode;
			} else {
				Node<T> nodeBefore = getNodeAt(position-1);
				Node<T> nodeAfter=  nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeBefore.setNext(newNode);
			}
			numOfEntries++;
		} else {
			//非运行时异常必须catch或者throws
			throw new IndexOutOfBoundsException("index out");
		}
	}

	@Override
	public T remove(int position) {
		T result = null;
		if(position>=1 && position <= numOfEntries) {
			if(position == 1) {
				result = firstNode.getData();
				firstNode = firstNode.getNext();
			} else {
				Node<T> nodeBefore = getNodeAt(position-1);
				Node<T> nodeToRemove = nodeBefore.getNext();
				result = nodeToRemove.getData();
				nodeBefore.setNext(nodeToRemove.getNext());
			}
			numOfEntries--;
			return result;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void clear() {
		initialDataField();
	}

	@Override
	public T replace(int position, T entry) {
		T result = null;
		if(position>=1 && position<=numOfEntries) {
			Node<T> nodeToReplace = getNodeAt(position);
			result = nodeToReplace.getData();
			nodeToReplace.setData(entry);
			return result;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T getEntry(int position) {
		T result = null;
		if(1<=position && position <= numOfEntries) {
			Node<T> node = getNodeAt(position);
			result = node.getData();
			return result;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numOfEntries];
		int index = 0;
		Node<T> currentNode = firstNode;
		while(index < numOfEntries && currentNode!=null) {
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNext();
		}
		return result;
	}

	@Override
	public boolean contain(T entry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while(!found && currentNode!=null) {
			if(entry.equals(currentNode.getData())) {
				found = true;
			} else {
				currentNode = currentNode.getNext();
			}
		}
		return found;
	}

	@Override
	public int getLength() {
		return numOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if(numOfEntries==0) {
			assert firstNode==null;
			result = true;
		}else {
			assert firstNode!=null : "numberOfEntries is 0 but firstNode is not null";
			result = false;
		}
		return result;
	}

	//position 位置
	private Node<T> getNodeAt(int position) {
		assert (firstNode != null) && (1 <= position) && (position <= numOfEntries);
		Node<T> currentNode= firstNode;
		for(int i=1; i<position; i++) {
			currentNode = currentNode.getNext();
		}
		assert currentNode != null;
		return currentNode;
	}
}
