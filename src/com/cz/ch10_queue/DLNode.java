package com.cz.ch10_queue;

public class DLNode<T> {

	private Node<T> preNode;
	private Node<T> nextNode;
	private T entry;
	public DLNode(Node<T> preNode, Node<T> nextNode, T entry) {
		super();
		this.preNode = preNode;
		this.nextNode = nextNode;
		this.entry = entry;
	}
	public Node<T> getPreNode() {
		return preNode;
	}
	public void setPreNode(Node<T> preNode) {
		this.preNode = preNode;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	public T getEntry() {
		return entry;
	}
	public void setEntry(T entry) {
		this.entry = entry;
	}
	
}
