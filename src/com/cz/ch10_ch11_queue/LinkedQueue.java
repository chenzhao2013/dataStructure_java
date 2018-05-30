package com.cz.ch10_ch11_queue;

public class LinkedQueue<T> implements QueueInterface<T>{

	private Node<T> firstNode;
	private Node<T> lastNode;
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}

	@Override
	public void enqueue(T entry) {
		Node<T> newNode = new Node<T>(entry);
		if(isEmpty())
			firstNode = newNode;
		else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);//这句话应该不需要吧
		firstNode = firstNode.getNext();
		if(firstNode==null)
			lastNode = null;
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else {
			return firstNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null && lastNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
