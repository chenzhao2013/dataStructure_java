package com.cz.sort;

import java.util.Arrays;

public class MoreSort {

	public static void main(String[] args) {
		int[] a = {1,7,4,3,6,10,3,4};
		int [] temp = new int[8];
		MoreSort.mergeSort(a,temp, 0, a.length-1);
		for(int each: a) {
			System.out.println(each);
		}
	}
	public static void mergeSort(int[] a, int[] tempArray, int first, int last) {
		if(first<last) {
			int mid = (first + last) / 2;
			mergeSort(a, tempArray, first, mid);
			mergeSort(a, tempArray, mid+1, last);
			merge(a, tempArray, first, mid, last);
		}
	}

	private static void merge(int[] a, int[] tempArray, int first, int mid, int last) {
		int leftBegin = first;
		int leftEnd = mid;
		int rightBegin = mid + 1;
		int rightEnd = last;
		int index = first;
		while(leftBegin<=leftEnd && rightBegin<=rightEnd) {
			if(a[leftBegin] <= a[rightBegin]) {
				tempArray[index] = a[leftBegin];
				leftBegin++;
			} else {
				tempArray[index] = a[rightBegin];
				rightBegin++;
			}
			index++;
		}
		if(leftBegin>leftEnd) {
			//将右边剩余项复制到数组
			for(int i=rightBegin;i<=rightEnd;i++) {
				tempArray[index++] = a[i];
			}
		}
		if(rightBegin>rightEnd) {
			for(int i=leftBegin;i<=leftEnd;i++)
				tempArray[index++] = a[i];
		}
		for(int i=0;i<index;i++)
			a[i] = tempArray[i];
	}
}
