package com.cz.ch12_ch13_list;


import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
public class TestArrayList {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ListInterface<String> list = new ArrayList<>(10);
		list.add("a");
		list.add("b");
		list.add("c");
		for(String item : list) {
			System.out.println(item);
		}
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
