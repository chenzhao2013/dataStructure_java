package com.cz.Stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class LinkedStack<T> implements StackInterface<T>{
	//Stack<String> stack = new Stack<>();
	private Node<T> topNode;
	
	
	@Override
	public T pop() {
		T top = peek();
		if(isEmpty())
			throw new EmptyStackException();
		topNode = topNode.getNext();
		return top;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return topNode.getData();
	}

	@Override
	public void push(T anEntry) {
		Node<T> node =new Node<T>(anEntry, topNode);
		//node.setNext(topNode.getNext());
		topNode = node;
	}

	@Override
	public boolean isEmpty() {
		return topNode==null;
	}

	@Override
	public void clear() {
		topNode=null;
	}
	
	public int count() {
		return countNode(topNode);
	}
	public int countNode(Node<T> node) {
		if(node==null) {
			return 0;
		} else if(node.getNext()==null) {
			return 1;
		} else {
			return 1 + countNode(node.getNext());
		}
	}

}
