package com.cz.recursive;

public class A extends B {

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 10;
	}
	public void a() {
		
	}
	
	public static void main(String[] args) {
		B b = new A();
		System.out.println(b.count());
	}

}
