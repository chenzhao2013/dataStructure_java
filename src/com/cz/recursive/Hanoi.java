package com.cz.recursive;

public class Hanoi {

	public void hanoi(int n, int start, int temp, int end) {
		if(n==1) {
			System.out.println(start+"-->"+end);
		} else {
			hanoi(n-1, start, end, temp);
			System.out.println(start+"-->"+end);
			hanoi(n-1, temp, start, end);
		}
	}
	public int fab(int n) {
		if(n<=1)
			return 1;
		else {
			return fab(n-1)+fab(n-2);
		}
	}
	public int fab_dietai(int n) {
		int f0 = 1;
		int f1 = 1;
		int f = 1;
		for(int i=1; i<n; i++) {
			f = f0 + f1;
			f0 = f1;
			f1 = f;
		}
		return f;
	}
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
//		hanoi.hanoi(4, 1, 2, 3);
		System.out.println(hanoi.fab_dietai(0));
	}
}
