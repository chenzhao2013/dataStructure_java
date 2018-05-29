package com.cz.ch10_queue;

public class LinkedDeque<T> implements DequeInterface<T> {

	private DLNode<T> frontNode;
	private DLNode<T> lastNode;
	
	public LinkedDeque() {
		frontNode = null;
		lastNode = null;
	}

	@Override
	public void addToFront(T entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToBack(T entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFront() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	
}
