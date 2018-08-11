package com.cz.ch23_ch24_tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.DefaultEditorKit.CutAction;

import com.cz.Stack.LinkedStack;
import com.cz.Stack.StackInterface;

public class BinaryTree<T> implements BinaryTreeInterface<T>{

	private BinaryNode<T> root;
	
	public BinaryTree() {
		super();
		this.root = null;
	}

	public BinaryTree(T rootData) {
		super();
		this.root = new BinaryNode<>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree,
			BinaryTree<T> rightTree) {
		super();
		privateSetTree(rootData, leftTree, rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if( leftTree !=null && !leftTree.isEmpty())
			root.setLeftNode(leftTree.root);
		if(rightTree != null && !rightTree.isEmpty())
			if(rightTree != leftTree) {
				root.setRightNode(rightTree.root);
			} else {
				root.setRightNode(rightTree.root.copy());
			}
		if(leftTree != null && leftTree != this) {
			leftTree.clear();
		}
		if(rightTree != null && rightTree != this) {
			rightTree.clear();
		}
	}

	@Override
	public T getRootData() {
		if(isEmpty())
			throw new IllegalStateException();
		return root.getData();
	}

	protected void setRootData(T entry) {
		root.setData(entry);
	}
	
	protected void setRootNode(BinaryNode<T> binaryNode) {
		root = binaryNode;
	}
	protected BinaryNode<T> getRootNode() {
		return root;
	}
	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		return new LevelorderIterator();
	}

	@Override
	public void setTree(T rootData) {
		root.setData(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	public void inorderTraverse() {
		inorderTraverse(root);
	}
	public void preorderTraverse() {
		preorderTraverse(root);
	}
	public void postorderTraverse() {
		postorderTraverse(root);
	}
	public void levelTraverse() {
		levelorderTraverse(root);
	}
	private void inorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			inorderTraverse(node.getLeftNode());
			System.out.println(node.getData());
			inorderTraverse(node.getRightNode());
		}
	}
	
	private void preorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			System.out.println(node.getData());
			preorderTraverse(node.getLeftNode());
			preorderTraverse(node.getRightNode());
		}
	}
	private void postorderTraverse(BinaryNode<T> node) {
		if(node != null) {
			postorderTraverse(node.getLeftNode());
			postorderTraverse(node.getRightNode());
			System.out.println(node.getData());
		}
	}
	private void levelorderTraverse(BinaryNode<T> node) {
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		if(node == null)
			return;
		queue.offer(node);
		Iterator<BinaryNode<T>> iterator = queue.iterator();
		while(iterator.hasNext()) {
			BinaryNode<T> tmp = queue.poll();
			if(tmp.hasLeftNode())
				queue.offer(tmp.getLeftNode());
			if(tmp.hasRightNode())
				queue.offer(tmp.getRightNode());
			System.out.println(tmp.getData());
		}
	}
	private class InorderIterator implements Iterator<T>{

		private StackInterface<BinaryNode<T>> stack;
		private BinaryNode<T> currentNode;
		public InorderIterator() {
			stack = new LinkedStack<>();
			currentNode = root;
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty() || currentNode != null;
		}

		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			while(currentNode!=null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftNode();
			}
			if(!stack.isEmpty()) {
				nextNode = stack.pop();
				assert nextNode != null;
				currentNode = nextNode.getRightNode();
			} else {
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}
	}
	private class PreorderIterator implements Iterator<T>{

		private Stack<BinaryNode<T>> stack = null;
		private BinaryNode<T> currentNode = null;
		public PreorderIterator() {
			stack = new Stack<>();
			currentNode = root;
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty() || currentNode != null;
		}
		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			if(currentNode != null) {
				stack.push(currentNode);
			}
			if(!stack.isEmpty()) {
				nextNode = stack.pop();
				if( nextNode.hasRightNode()) {
					stack.push(nextNode.getRightNode());
				}
				currentNode = nextNode.getLeftNode();
			}
			return nextNode.getData();
		}
	}
	
	private class PostorderIterator implements Iterator<T>{

		private BinaryNode<T> currentNode;
		private BinaryNode<T> preNode;
		private Stack<BinaryNode<T>> stack;
		
		public PostorderIterator() {
			currentNode = root;
			preNode = null;
			stack = new Stack<>();
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty() || currentNode != null;
		}

		@Override
		public T next() {
			BinaryNode<T> nextNode = currentNode;
			while(true) {
				if( currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.getLeftNode();
				} else {
					currentNode = stack.peek();
					if(currentNode.hasRightNode() && preNode != currentNode.getRightNode()) {
						currentNode = currentNode.getRightNode();						
					} else {
						break;
					}
				}
			}
			currentNode = preNode = stack.pop();
			nextNode = currentNode;
			currentNode = null;
			return nextNode.getData();
		}
	}
	
	private class LevelorderIterator implements Iterator<T>{

		private Queue<BinaryNode<T>> queue;
		private BinaryNode<T> currentNode;
		public LevelorderIterator() {
			queue = new LinkedList<>();
			currentNode = root;
			if(currentNode!=null)
				queue.offer(currentNode);
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			BinaryNode<T> next = queue.poll();
			if(next.hasLeftNode())
				queue.offer(next.getLeftNode());
			if(next.hasRightNode())
				queue.offer(next.getRightNode());
			return next.getData();
		}
		
	}
}
