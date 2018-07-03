package com.cz.ch12_ch13_list;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LListTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		LList<String> list = new LList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add(2,"bb2");
		for(String item : list) {
			System.out.println(item);
		}
//		list.iterator();
	}

}
