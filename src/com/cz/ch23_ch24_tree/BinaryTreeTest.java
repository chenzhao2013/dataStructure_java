package com.cz.ch23_ch24_tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	BinaryTree<String> totalTree = null;
	@BeforeEach
	void setUp() throws Exception {
		BinaryTree<String> tree = new BinaryTree<>("b",new BinaryTree<>("d"), new BinaryTree<>("e"));
		BinaryTree<String> rightTree = new BinaryTree<>("f",null,new BinaryTree<>("g"));
		BinaryTree<String> rightTree2 = new BinaryTree<>("c", rightTree, null);
		totalTree = new BinaryTree<>("a", tree, rightTree2);
	}

	@Test
	void testInorderTra() {
		totalTree.inorderTraverse();
	}
	@Test
	void testPreTra() {
		totalTree.preorderTraverse();
	}
	@Test
	void testPostTra() {
		totalTree.postorderTraverse();
	}
	@Test
	void testPreorderIte() {
		Iterator<String> iterator = totalTree.getPreorderIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	@Test
	void testInorderIte() {
		Iterator<String> iterator = totalTree.getInorderIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	@Test
	void testPostorderIte() {
		Iterator<String> iterator = totalTree.getPostorderIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
