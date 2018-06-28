package com.cz.ch12_ch13_list;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
public class TestArrayList {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(1, 10);
		list.forEach(item->{
			System.out.println(item);
		});
	}

}
