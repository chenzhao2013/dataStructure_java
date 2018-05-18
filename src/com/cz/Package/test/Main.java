package com.cz.Package.test;

import com.cz.Package.ArrayBag;
import com.cz.Package.BagInterface;

public class Main {

	public static void main(String[] args) {
		BagInterface<String> bagInterface = new ArrayBag<>();
		((ArrayBag<String>) bagInterface).removeEntry(1);
	}
}
