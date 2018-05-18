package com.cz.recursive;

import java.util.Scanner;

import com.cz.Stack.LinkedStack;
import com.cz.Stack.Node;
import com.cz.Stack.StackInterface;

public class Exercises2 {

	public static void main(String[] args) {
		Exercises2 exercises2 = new Exercises2();
		//System.out.println(exercises2.ex4_jiech2(1, 5));
		int a[] = {1,2,3,4,5,6,7,8,9};
		String str = "sssdedsss";
		//System.out.println(exercises2.ex8_huiwen2(str,0,str.length()-1));
		int[] b = new int[11];
		//System.out.println(exercises2.ex9_fab2(2));
		exercises2.ex12_displaydata(124513);
	}
	public void ex12_displaydata(int n) {
		if(n<10) {
			System.out.println(n);
		}else {
			ex12_displaydata(n/10);
			ex12_displaydata(n%10);
		}
	}
	public <T> int  ex11_count(StackInterface<T> stack) {
		//if(stack.)
		return 1;
	}
	public int ex9_fab2(int n) {//O(n)
		int f0 = 1;
		int f1 = 1;
		int currFab = 1;
		for(int i=1;i<n;i++) {
			currFab = f0+f1;
			f0 = f1;
			f1 = currFab;
		}
		return currFab;
	}
	public int ex9_fab1(int[] a, int n) {//O(n)
		a[0] = 1;
		a[1] = 1;
		if(n<2) {
			return a[n];
		}
		for(int i=2; i<=n; i++) {
			a[i] = a[i-2] + a[i-1];
		}
		return a[n];
	}
	public boolean ex8_huiwen2(String str, int start, int last) {
		if(start>=last) {
			return true;
		}
		if(str.charAt(start)==str.charAt(last)) {
			return ex8_huiwen2(str, ++start, --last);
		} else {
			return false;
		}
//		if(start==str.length()/2) {
//			return true;
//		} else {
//			if(str.charAt(start)==str.charAt(last)) {
//				return ex8_huiwen2(str, ++start, --last);
//			} else {
//				return false;
//			}
//		}
//		if(start <= last) {
//			if(str.charAt(start)==str.charAt(last))
//				return ex8_huiwen2(str, ++start, --last);
//			else {
//				return false;
//			}
//		} else {
//			return true;
//		}
		
	}
	public boolean ex8_huiwen1(String str) {
		boolean result = true;
		int length = str.length();
		int mid = length/2;
		StackInterface<Character> stack = new LinkedStack<>();
		for(int i=0;i<mid;i++) {
			stack.push(str.charAt(i));
		}
		int start = length%2 == 0 ? mid: mid+1;
		for(int j=start;j<length;j++) {
			if(!stack.isEmpty()&&stack.pop()!=str.charAt(j)) {
				result =false;
			}
		}
		return result;
	}
	public void ex7_reverseString2(String str, int first) {
		if(first<str.length()-1) {
			ex7_reverseString2(str, ++first);
			System.out.println(str.charAt(first));
		}
	}
	public void ex7_reverseString1(String str, int last) {
		if(last>-1) {
			System.out.println(str.charAt(last));
			ex7_reverseString1(str, last-1);
		}
	}
	public void ex6_reverseDisplay(int[] a, int first) {
		if(first < a.length) {
			ex6_reverseDisplay(a, first+1);
			System.out.println(a[first]);
		}
	}
	public void ex5_reverseDisplay(int[] a, int last) {
		if(last > -1) {
			System.out.println(a[last]);
			ex5_reverseDisplay(a, last-1);
		}
	}
	public long ex4_jiech2(int m,int n) {
		if(m==n) {
			return n;
		}else {
			return m*ex4_jiech2(m+1, n);
		}
	}
	public long ex4_jiecheng(int n) {
		if(n==0) {
			return 1;
		}else {
			return n*ex4_jiecheng(n-1);
		}
	}
	public void ex3() {
		System.out.println("input a integer:");
		Scanner scanner = new Scanner(System.in);
		int next = scanner.nextInt();
		if(next<1||next>10) {
			ex3();
		}else {
			System.out.println(next);
			System.out.println("end");
		}
	}
	public void ex2(double d) {
		
		if(d<1) {
			return;
		} else {
			draw(d);
			ex2(d*3/4);
		}
	}
	
	private void draw(double d) {
		// TODO Auto-generated method stub
		System.out.println("draw"+"d="+d);
	}
	public void ex1(char log, int no) {
		System.out.print(log);
		if(no==1)
			System.out.println("end");
		else {
			ex1(log, no-1);
		}
		
	}
}
