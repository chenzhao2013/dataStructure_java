package com.cz.ch25_searchTree;

import com.cz.ch23_ch24_tree.BinaryNode;
import com.cz.ch23_ch24_tree.BinaryTree;
import com.cz.ch23_ch24_tree.BinaryTreeInterface;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));//不能使用setRootData,因为默认构造方法使得root为空指针
	}

	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}
	
	private T findEntry(BinaryNode<T> root, T entry) {
		T result = null;
		if(root != null) {
			T rootEntry = root.getData();
			if(entry.equals(rootEntry)) {
				result = entry;
			} else if(entry.compareTo(rootEntry) < 0) {
				result = findEntry(root.getLeftNode(), entry);
			} else {
				result = findEntry(root.getRightNode(), entry);
			}
		}
		return result;
	}
	
	@Override
	public T add(T entry) {
		if(isEmpty()) {
			setRootNode(new BinaryNode<>(entry));
			return null;
		} else {
			return addEntry(getRootNode(), entry);
		}
	}

	//add 递归版
	private T addEntry(BinaryNode<T> rootNode, T entry) {
		assert rootNode != null;
		T result = null;
		int compare = entry.compareTo(rootNode.getData());
		if(compare == 0) {
			result = rootNode.getData();
			rootNode.setData(entry);
		} else if (compare < 0) {
			if(rootNode.hasLeftNode()) {
				result = addEntry(rootNode.getLeftNode(), entry);
			} else {
				rootNode.setLeftNode(new BinaryNode<>(entry));
			}
		} else {
			if(rootNode.hasRightNode()) {
				result = addEntry(rootNode.getRightNode(), entry);
			} else {
				rootNode.setRightNode(new BinaryNode<>(entry));
			}
		}
		return result;
	}
	
	//add 迭代版
	private T addEntryIte(T entry){
		T result = null;
		BinaryNode<T> currnetNode = getRootNode();
		boolean found = false;
		while(!found) {
			int compare = entry.compareTo(currnetNode.getData());
			if(compare == 0) {
				found = true;
				result = getRootData();
				setRootData(entry);
			} else if (compare < 0) {
				if(currnetNode.hasLeftNode()) {
					currnetNode = currnetNode.getLeftNode();
				} else {
					found = true;
					currnetNode.setLeftNode(new BinaryNode<>(entry));
				}
			} else {
				if(currnetNode.hasRightNode()) {
					currnetNode = currnetNode.getRightNode();
				} else {
					found = true;
					currnetNode.setRightNode(new BinaryNode<>(entry));
				}
			}
		}
		return result;
	}
	@Override
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject();
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.getOldEntry();
	}

	private T removeDieDai(T entry) {
		T result = null;
		//找到删除的结点
		BinaryNode<T> currNode = getRootNode();
		BinaryNode<T> parNode = null;
		boolean found = false;
		while(!found && currNode != null) {
			T currData = currNode.getData();
			int compare = entry.compareTo(currData);
			if(compare == 0) {
				found = true;
			} else if( compare < 0) {
				parNode = currNode;
				currNode = currNode.getLeftNode();
			} else {
				parNode = currNode;
				currNode = currNode.getRightNode();
			}
		}
		
		//找到了entry
		BinaryNode<T> nodeToRemove = null;
		BinaryNode<T> prioNode = null;
		if(currNode != null) {
			result = currNode.getData();
			if(currNode.hasLeftNode() && currNode.hasRightNode()) {
				//找到需要删除的结点
				//nodeToRemove = ;
				prioNode = currNode;
				BinaryNode<T> rightNode = currNode.getLeftNode();
				while(rightNode.hasRightNode()) {
					prioNode = rightNode;
					rightNode = rightNode.getRightNode();
				}
				nodeToRemove = rightNode;
				parNode = prioNode;
//				currNode.setData(rightNode.getData());
//				currNode = rightNode;
			}
			
			//删除rightNode
			BinaryNode<T> childNode;
			if(nodeToRemove.hasLeftNode())
				childNode = nodeToRemove.getLeftNode();
			else 
				childNode = nodeToRemove.getRightNode();
			if(nodeToRemove == getRootNode())
				setRootNode(childNode);
			else if(parNode.getLeftNode() == nodeToRemove)
				parNode.setLeftNode(childNode);
			else
				parNode.setRightNode(childNode);
		}
		return result;
	}
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, BinarySearchTree<T>.ReturnObject oldEntry) {
		if(rootNode != null ) {
			T rootData = getRootData();
			int compare = entry.compareTo(rootData);
			if( compare == 0) {
				oldEntry.setOldEntry(rootData);
				rootNode = removeFromRoot(rootNode);
			}else if(compare <0) {
				//删除的结点在左子树中
				BinaryNode<T> leftChild = rootNode.getLeftNode();
				BinaryNode<T> subTreeRoot = removeEntry(leftChild, entry, oldEntry);
				setRootNode(subTreeRoot);
			} else {
				//删除的结点在右子树中
				BinaryNode<T> rightChild = rootNode.getRightNode();
				BinaryNode<T> subTreeRoot = removeEntry(rightChild, entry, oldEntry);
				setRootNode(subTreeRoot);
			}
		}
		return rootNode;
	}

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
		if(rootNode.hasLeftNode() && rootNode.hasRightNode()) {
			//使用左子树中最大的项替换跟结点数据
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftNode();
			BinaryNode<T> largestNode = findLagest(leftSubtreeRoot);
			rootNode.setData(largestNode.getData());
			rootNode.setLeftNode(removeLargest(leftSubtreeRoot));
		} else if(rootNode.hasRightNode()) {
			rootNode = rootNode.getRightNode();
		} else {
			rootNode = rootNode.getLeftNode();
		}
		return rootNode;
	}

	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if(rootNode.hasRightNode()) {
			BinaryNode<T> rightNode = rootNode.getRightNode();
			rightNode = removeLargest(rightNode);
			rootNode.setRightNode(rightNode);
		} else {
			rootNode = rootNode.getLeftNode();
		}
		return rootNode;
	}

	private BinaryNode<T> findLagest(BinaryNode<T> rootNode) {
		if(rootNode.hasRightNode()) {
			rootNode = findLagest(rootNode.getRightNode());
		}
		return rootNode;
	}

	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	class ReturnObject {
		private T oldEntry;
		public ReturnObject() {
			super();
		}
		public T getOldEntry() {
			return oldEntry;
		}
		public void setOldEntry(T oldEntry) {
			this.oldEntry = oldEntry;
		}
	}
	class NodePair{
		private BinaryNode<T> first;
		private BinaryNode<T> second;
		public NodePair(BinaryNode<T> first, BinaryNode<T> second) {
			super();
			this.first = first;
			this.second = second;
		}
		public BinaryNode<T> getFirst() {
			return first;
		}
		public void setFirst(BinaryNode<T> first) {
			this.first = first;
		}
		public BinaryNode<T> getSecond() {
			return second;
		}
		public void setSecond(BinaryNode<T> second) {
			this.second = second;
		}
	}
}
