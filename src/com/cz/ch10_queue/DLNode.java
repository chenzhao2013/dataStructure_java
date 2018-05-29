package com.cz.ch10_queue;

public class DLNode<T> {

	private DLNode<T> preNode;
	private DLNode<T> nextNode;
	private T entry;
	public DLNode(DLNode<T> preNode, DLNode<T> nextNode, T entry) {
		super();
		this.preNode = preNode;
		this.nextNode = nextNode;
		this.entry = entry;
	}
	public DLNode<T> getPreNode() {
		return preNode;
	}
	public void setPreNode(DLNode<T> preNode) {
		this.preNode = preNode;
	}
	public DLNode<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(DLNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	public T getEntry() {
		return entry;
	}
	public void setEntry(T entry) {
		this.entry = entry;
	}
	
}
