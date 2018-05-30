package com.cz.ch10_ch11_queue;

public class LinkedDeque<T> implements DequeInterface<T> {

	private DLNode<T> frontNode;
	private DLNode<T> lastNode;
	
	public LinkedDeque() {
		frontNode = null;
		lastNode = null;
	}

	@Override
	public void addToFront(T entry) {
		DLNode<T> newNode = new DLNode<T>(null, frontNode, entry);
		if(isEmpty()) {
			lastNode = newNode;
		}else {
			frontNode.setPreNode(newNode);
		}
		frontNode = newNode;
	}

	@Override
	public void addToBack(T entry) {
		DLNode<T> newNode = new DLNode<T>(lastNode, null, entry);
		if(isEmpty()) {
			frontNode = newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T frontEntry = getFront();
		frontNode = frontNode.getNextNode();
		if(frontNode==null) {
			lastNode = null;
		}else {
			frontNode.setPreNode(null);
		}
		return frontEntry;
	}

	@Override
	public T removeBack() {
		T lastEntry = getBack();
		lastNode = lastNode.getPreNode();
		if(lastNode==null) {
			frontNode = null;
		}else {
			lastNode.setNextNode(null);
		}
		return lastEntry;
	}

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}else {
			return frontNode.getEntry();
		}
	}

	@Override
	public T getBack() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}else {
			return lastNode.getEntry();
		}
	}

	@Override
	public boolean isEmpty() {
		return frontNode==lastNode;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			removeFront();
	}


	
}
