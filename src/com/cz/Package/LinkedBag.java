package com.cz.Package;

public class LinkedBag<T> implements BagInterface<T> {

	private Node<T> firstNode;
	private int numberOfEntries;
	
	public LinkedBag() {
		super();
		this.firstNode = null;
		this.numberOfEntries = 0;
	}

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode==null||numberOfEntries==0;
	}



	@Override
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);
		newNode.setNext(firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}



	@Override
	public synchronized T remove() {
		T result = null;
		if(firstNode!=null) {
			result = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		}
		return result;
	}



	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> ref = getReferenceTo(anEntry);
		if(ref!=null) {//将头结点替换到该节点，然后删除头结点，
			//不同于线性表或者栈的删除节点并移动数据
			ref.setData(firstNode.getData());
			firstNode = firstNode.getNext();
			numberOfEntries--;
			result = true;
		} 
		return result;
	}



	@Override
	public void clear() {
		while(!isEmpty())
			remove();
	}



	@Override
	public int getFrequenceOf(T anEntry) {
		int count = 0;
		Node<T> currNode = firstNode;
		while(currNode!=null) {
			if(currNode.getData()==anEntry)
				count++;
			currNode=currNode.getNext();
		}
		return count;
	}



	@Override
	public boolean contains(T anEntry) {
//		boolean result = false;
//		Node<T> currNode = firstNode;
//		while(currNode!=null) {
//			if(currNode.getData()==anEntry) {
//				result = true;
//				break;
//			}
//			currNode = currNode.getNext();
//		}
		return getReferenceTo(anEntry)!=null;
	}



	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[numberOfEntries];
		Node<T> currNode = firstNode;
		int index = 0;
		while(currNode!=null) {
			result[index] = currNode.getData();
			index++;
			currNode = currNode.getNext();
		}
		return result;
	}
	public Node<T> getReferenceTo(T anEntry) {
		Node<T> result = null;
		Node<T> currNode = firstNode;
		while(currNode!=null) {
			if(currNode.getData()==anEntry) {
				result = currNode;
				break;
			}else {
				currNode = currNode.getNext();
			}
		}
		return result;
	}
	public void display() {
		displayChain(firstNode);
	}
	
	private void displayChain(Node<T> node) {
		if(node!=null) {
			System.out.println(node.getData());
			displayChain(node.getNext());
		}
	}
	public void reverseDisplay() {
		reverseDisplayChain(firstNode);
	}
	
	private void reverseDisplayChain(Node<T> node) {
		if(node!=null) {
			displayChain(node.getNext());
			System.out.println(node.getData());
		}
	}
}
