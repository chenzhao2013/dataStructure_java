package com.cz.Package.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cz.Package.ArrayBag;
import com.cz.Package.BagInterface;

class ArrayBagTest {
	BagInterface<String> aBag;
	String[] contentOfBag1 = {"A","A","B","A","C","A"};
	BagInterface<String> bBag;
	String[] contentOfBag2 = {"a","b","a","c","b","a","d"};
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Test an bag with sufficient "
				+ "capacity the capacity to hold at least 6 strings");
		aBag = new ArrayBag<>();
		bBag = new ArrayBag<>(7);
		testAdd();
	}

	@Test
	void testAdd() {
		System.out.println("Adding following "+contentOfBag1.length
				+" strings to the bag:");
		for(int i=0;i<contentOfBag1.length;i++) {
			if(aBag.add(contentOfBag1[i])) {
				System.out.println(contentOfBag1[i] + " ");
			} else {
				System.out.println("Unable to add "+ contentOfBag1[i]
						+" to the bag");
			}
		}
		String[] a = aBag.toArray();
		for(String aS : a)
		System.out.println(aS);
	}

	@Test
	void testToArray() {
		Object[] result = aBag.toArray();
		for(Object a: result) {
			System.out.println(a);
		}
	}

}
