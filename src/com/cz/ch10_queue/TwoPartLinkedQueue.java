package com.cz.ch10_queue;

public class TwoPartLinkedQueue<T> implements QueueInterface<T> {

	private Node<T> queueNode;
	private Node<T> freeNode;
	
	public TwoPartLinkedQueue() {
		freeNode = new Node<T>(null,null);
		freeNode.setNext(freeNode);
		queueNode = freeNode;
	}
	@Override
	public void enqueue(T entry) {
		freeNode.setData(entry);
		if(isChainFull()) {//链满了，就新建node，并调整freeNode
			Node<T> newNode = new Node<T>(null, freeNode.getNext());
			freeNode.setNext(newNode);
		}
		freeNode = freeNode.getNext();
	}

	private boolean isChainFull() {
		return freeNode.getNext()==queueNode;
	}
	@Override
	public T dequeue() {
		T front = getFront();
		assert !isEmpty();
		queueNode.setData(null);
		queueNode = queueNode.getNext();
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}else {
			return freeNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return queueNode == freeNode;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			dequeue();
	}

}
