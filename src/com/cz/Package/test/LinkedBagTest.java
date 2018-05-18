package com.cz.Package.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cz.Package.BagInterface;
import com.cz.Package.LinkedBag;

class LinkedBagTest {
	LinkedBag<String> linkedBag = null;

	@BeforeEach
	void setUp() throws Exception {
		linkedBag = new LinkedBag<>();
	}

	@Test
	void test() {
		testIsEmpty(linkedBag, true);
	}

	@Test
	void testAdd() {
		linkedBag.add("gdhshg");
		linkedBag.add("jdsds");
		linkedBag.display();
		System.out.println("------");
		linkedBag.reverseDisplay();
	}

	private void testIsEmpty(BagInterface<String> bag, boolean empty) {
		if (empty && bag.isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println("not empty");
		}
	}

	@Test
	public void testRemove() {
//		linkedBag.add("gdhshg");
//		linkedBag.add("jdsds");
		// System.out.println(linkedBag.remove());
		// System.out.println(linkedBag.remove());
		// System.out.println(linkedBag.remove());
		// 这个地方传"jdsds" return true，因为是同一个对象
		// 如果是new String("jdsds"), return false ==将字符串判断为不同对象
		// Set<String> a = new HashSet<>();
		System.out.println(linkedBag.getCurrentSize());
		List<Thread> list = new ArrayList<>();
		for(int i=0;i<1000;i++)
			linkedBag.add("gh"+i);
		System.out.println(linkedBag.getCurrentSize());
		for(int i =0; i<100; i++) {
			//synchronized (this) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public synchronized void run() {
						linkedBag.remove();
						System.out.println(linkedBag.getCurrentSize());
					}
				});
				thread.start();
				list.add(thread);
			//}
		}
		while(true) {
			List<Thread> a = list.stream().filter(item->item.isAlive()).collect(Collectors.toList());
			if(a.size()==0) {
				System.out.println("结束"+linkedBag.getCurrentSize());
				break;
			}
		}
	}
}
