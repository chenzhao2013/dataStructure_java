package com.cz.extern;

public class BB extends AA {

	public BB() {
		m();
	}
	@Override
	public void m() {
		super.m();
		System.out.println("子类的m方法");
	}
	public static void main(String[] args) {
		AA aa = new BB();
		aa.toString();
	}
}
