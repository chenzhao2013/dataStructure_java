package com.cz.recursive;

import com.cz.Stack.LinkedStack;
import com.cz.Stack.StackInterface;

public class Exercises {

	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		display5(a, 4, 10);
		//System.out.println(multi(20));
		//countUp(10);
		//skipNLine(10);
	}
	public static void display5(int[] a, int first, int last) {
		Record record = new Record(first, last);
		StackInterface<Record> stack = new LinkedStack<>();
		stack.push(record);
		while(!stack.isEmpty()) {
			Record top = stack.pop();
			last = top.getLast();
			first = top.getFirst();
			if(last==first)
				System.out.println(a[first]);
			else {
				int mid = first + (last-first) / 2;
				stack.push(new Record(mid + 1, last));
				stack.push(new Record(first, mid));
			}
		}
	}
	static class Record {
		private int first;
		private int last;
		public Record(int first, int last) {
			this.first = first;
			this.last = last;
		}
		public int getFirst() {
			return first;
		}
		public void setFirst(int first) {
			this.first = first;
		}
		public int getLast() {
			return last;
		}
		public void setLast(int last) {
			this.last = last;
		}
	}
	public static void display4(int[] a, int first, int last) {
		System.out.println("first"+first);
		System.out.println("last" + last);
		System.out.println("-------------");
		if(first == last) {
			System.out.println(a[first]);
		}else {
			int mid = first + (last-first) / 2;
			display4(a, first, mid);
			display4(a, mid + 1, last);
		}
	}
	public static void display3(int[] a, int start, int last) {
		if(start<=last) {
			display3(a, start, last-1);
			System.out.println(a[last]);
		}
	}
	public static void display2(int[] a, int start, int last) {
		System.out.println(a[start]);
		if(start<last) {
			display2(a, start+1, last);
		}
	}
	//显示数组区间数据
	public static void display(int[] a, int start, int last) {
		int length = a.length;
		if(start<1||start > length||last > length) {
			throw new IllegalStateException("超出数组下标");
		}
		if(start==last) {
			
		}else {
			display(a, start, last-1);
		}
		System.out.println(a[last-1]);
	}
	//test4
	public static int multi(int n) {
		int ji = 1;
		if(n==1) {
			ji=1;
		}else {
			ji = multi(n-1)*n;
		}
		return ji;
	}
	//sum
	public static int sum(int n) {
		int sum = 0;
		if(n==1) {
			sum = 1;
		}else {
			sum = sum(n-1)+n;
		}
		return sum;
	}
	//test1
	public static void skipNLine(int n) {
		if(n>0) {
			System.out.println();
			skipNLine(n-1);
			System.out.println("skip "+ n+ "line");
		}
	}
	//test3
	public static void countUp(int n) {
		if(n>=1) {
			countUp(n-1);
		}
		System.out.println(n);
	}
}
