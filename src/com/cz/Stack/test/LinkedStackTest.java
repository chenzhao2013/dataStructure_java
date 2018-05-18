package com.cz.Stack.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cz.Stack.LinkedStack;
import com.cz.Stack.StackInterface;

class LinkedStackTest {

	StackInterface<String> stack = new LinkedStack<>();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		stack.push("khdhas");
		stack.push("jkfjhjds");
		stack.push("kkdjgjhsaj");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	@Test
	void testCount() {
		stack.push("khdhas");
		stack.push("jkfjhjds");
		stack.push("kkdjgjhsaj");
		System.out.println(((LinkedStack<String>)stack).count());
	}
	@Test
	public void testOthers() {
		stack.push("khdhas");
		stack.push("jkfjhjds");
		stack.push("kkdjgjhsaj");
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		//System.out.println(stack.);
		stack.clear();
	}
}
