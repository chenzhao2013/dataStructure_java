package com.cz.ch12_ch13_list;


import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.transformation.SortedList;

class LListTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
//		LList<String> list = new LList<>();
//		int index =0;
//		long timeStamp = System.currentTimeMillis();
//		System.out.println(timeStamp);
//		while(index!=100000) {
//			list.add(""+index);
//			index++;
//		}
//		System.out.println((System.currentTimeMillis()-timeStamp));
//		list.add("aa");
//		list.add("bb");
//		list.add("cc");
//		list.add(2,"bb2");
//		long timeStamp2 = System.currentTimeMillis();
//		for(String item : list) {
//			System.out.println(item);
//		}
//		System.out.println((System.currentTimeMillis()-timeStamp2));
//		list.iterator();
//		ArrayList<String> arrayList = new ArrayList<>();
//		arrayList.listIterator();
//		arrayList.iterator();
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("b");
		treeSet.add("a");
		treeSet.add("c");
		for(String item : treeSet) {
			System.out.println(item);
		}
	}

}
