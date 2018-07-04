package com.cz.ch12_ch13_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.org.apache.xml.internal.security.Init;

import sun.launcher.resources.launcher;

public class LListWithTail<T> implements ListInterface<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int numOfEntries;
	public LListWithTail() {
		init();
	}
	private void init() {
		firstNode = null;
		lastNode = null;
		numOfEntries = 0;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T entry) {
		Node<T> newNode = new Node<T>(entry);
		if(isEmpty()) {
			firstNode = newNode;
		}else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
	}

	@Override
	public void add(int position, T entry) {
		if(position >= 1 && position <= numOfEntries+1) {
			Node<T> newNode= new Node<T>(entry);
			if(isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if(position == 1){
				newNode.setNext(firstNode);
				firstNode = newNode;
			} else if( position == numOfEntries+1){
				lastNode.setNext(newNode);
				lastNode = newNode;
			} else {
				Node<T> nodeBefore = getNodeAt(position-1);
				Node<T> nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeBefore.setNext(newNode);
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	private Node<T> getNodeAt(int position) {
		if(position>=1 && position <=numOfEntries) {
			Node<T> currentNode = firstNode;
			while(position<numOfEntries) {
				currentNode = currentNode.getNext();
			}
			assert currentNode != null;
			return currentNode;
		} else {
			throw new NoSuchElementException();
		}
	}
	@Override
	public T remove(int position) {
		T result = null;
		if(position>=1 && position <= numOfEntries) {
			if(position==1) {
				result = firstNode.getData();
				firstNode = firstNode.getNext();
				if(numOfEntries==1)
					lastNode =null;
			} else {
				Node<T> nodeBefore = getNodeAt(position-1);
				Node<T> nodeToRemove = nodeBefore.getNext();
				Node<T> nodeAfter = nodeToRemove.getNext();
				result = nodeToRemove.getData();
				nodeBefore.setNext(nodeAfter);
				if(position==numOfEntries) {
					lastNode = nodeBefore;
				}
				numOfEntries--;
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		return result;
	}

	@Override
	public void clear() {
		init();
	}

	@Override
	public T replace(int position, T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contain(T entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
