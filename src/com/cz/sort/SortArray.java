package com.cz.sort;
/**
 * ① shell sort O(n^1.5)
 * ② insert sort iterator & recursive O(n^2)
 * ③ select sort iterator & recursive O(n^2)
 * @author ChenZhao
 *
 */
public class SortArray {
	
	public static void main(String[] args) {
		int[] a = {1,7,4,3,6,10,3,4};
		SortArray.shellSort(a, 0, a.length-1);
		for(int each: a) {
			System.out.println(each);
		}

	}
	
	public static void shellSort(int[] a, int first, int last) {
		int n = a.length;
		int space = n/2;
		while(space>0) {
			for(int begin=first; begin<=last; begin=begin+space)
				incrementalInsertionSort(a, begin, last, space);
			space /= 2;
		}
	}
	public static void incrementalInsertionSort(int[] a, int first, int last, int space) {
		for(int unsort=first+space; unsort<=last; unsort=unsort+space) {
			int item = a[unsort];
			int index = unsort-space;
			while(index>=first && item<a[index]) {
				a[index+space] = a[index];
				index = index-space;
			}
			a[index+space] = item;
		}
	}
	//递归插入排序
	public static void insertSorted_recursive(int[] a, int first, int last) {
		if( first < last) {
			insertSorted_recursive(a, first, last-1);
			insertInOrder_Recursive(a, a[last], first, --last);
		}
	}
	private static void insertInOrder_Recursive(int[] a, int item, int first, int end) {
		if(item>a[end]) {
			a[end+1] = item;
		} else if( first < end ){
			a[end+1] = a[end];
			insertInOrder_Recursive(a, item, first, end-1);
		} else {
			a[end+1] = a[end];
			a[end] = item;
		}
	}
	//迭代插入排序
	public static void insertSorted(int[] a, int first, int last) {
		for(int unsorted = first+1; unsorted<=last; unsorted++) {
			int unsortedItem = a[unsorted];
			insertInOrder(a, unsortedItem, first, unsorted-1);
		}
	}
	private static void insertInOrder(int[] a, int unsortedItem, int first, int last) {
		int insertIndex = last;
		while(insertIndex>=first && unsortedItem < a[insertIndex]) {
			a[insertIndex + 1] = a[insertIndex];
			insertIndex--;
		}
		a[insertIndex + 1] = unsortedItem;
	}
	//递归选择排序
	public static void selectionSort(int[] a, int first, int last) {
		if(first < last) {
			int minIndex = getIndexOfSmallestItem(a, first, last);
			swap(a, first, minIndex);
			selectionSort(a, ++first, last);
		}
	}
	public static int getIndexOfSmallestItem(int[] a, int first, int last) {
		int min = a[first];
		int minIndex = first;
		for(int i=first+1; i<=last; i++) {
			if(a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	// 迭代选择排序
	public static void selectionSort(int[] a, int len) {
		for(int i=0; i<len; i++) {
			int min = a[i];
			int minIndex = i;
			for(int j=i+1;j<len;j++) {
				if(a[j]<min) {
					min = a[j];
					minIndex = j;
				}
			}
			swap(a, i, minIndex);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
//		if(i!=j) {
//			a[j] = a[i] ^ a[j];
//			a[i] = a[i] ^ a[j];
//			a[j] = a[i] ^ a[j];
//		}
		
	}
}
