package com.cz.ch10_ch11_queue;

public class Node<T> {

	private T data;
	private Node<T> next;
	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(T data) {
		super();
		this.data = data;
		next = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
