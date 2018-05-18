package com.cz.Stack.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cz.Stack.ResiableArrayStack;
import com.cz.Stack.StackInterface;

class ResiableArrayStackTest {

	StackInterface<String> stack = new ResiableArrayStack<>();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		stack.push("ksdhshf");
		stack.push("ss");
		stack.push("aa");
		stack.push("ff");
		stack.push("ssff");
		StackInterface<String> a = ((ResiableArrayStack<String>)this.stack).returnThis();
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		a.clear();
		stack.pop();
	}

}
