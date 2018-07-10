package com.cz.extern;

public class MyObj2 extends MyObj {

	public static void main(String[] args) {
		MyObj2 myObj2 = new MyObj2();
		try {
			myObj2.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void name() throws CloneNotSupportedException {
		super.clone();
	}
}
