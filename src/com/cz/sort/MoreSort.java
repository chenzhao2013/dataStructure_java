package com.cz.sort;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * ①基数排序 平均是O(n)
 * ②快速排序 平均是O(nlogn)
 * ③归并排序 一直是O(nlogn)
 * @author ChenZhao
 *
 */
public class MoreSort {

	public static void main(String[] args) {
		int[] a = {9,6,2,4,8,7,5,3};
//		int [] temp = new int[8];
		MoreSort.quickSort(a, 0, a.length-1);
		for(int each: a) {
			System.out.println(each);
		}
	}
	public static void radixSort(int[] a, int first, int last, int maxDigits) {
		
	}
	public static void quickSort(int[] a, int first, int last) {
		int MIN_SIZE = 4;//当小于4时，使用插入排序
		if(last-first+1<MIN_SIZE) {
			SortArray.insertSorted(a, first, last);
		}else {
			int pivotIndex = partition(a, first, last);
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		}
	}
	public static int partition(int[] a, int first, int last) {
		int mid = first + (last-first) / 2;
		//三元中值枢轴选择法，即在首、尾、中间值选择中位值
		sortFirstMiddleLast(a, first, mid, last);
		//交换枢轴到倒数第二个位置， 因为最后一个数肯定不小于枢轴，所有不用调整位置
		swap(a, mid, last-1);
		int pivotIndex = last - 1;
		int pivotValue = a[pivotIndex];
		int indexFromLeft = first + 1;
		int indexFromRight = pivotIndex - 1;//last-2
		boolean done = false;
		while(!done) {
			while(a[indexFromLeft]<pivotValue)
				indexFromLeft++;
			while(a[indexFromRight]>pivotValue)
				indexFromRight--;
			if(indexFromLeft<indexFromRight) {
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}else {
				done = true;
			}
		}
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		return pivotIndex;
	}
	private static void sortFirstMiddleLast(int[] a, int first, int mid, int last) {
		if(a[first]>a[last])
			swap(a, first, last);
		if(a[mid]>a[last])
			swap(a, mid, last);
		if(a[first]>a[mid])
			swap(a, first, mid);
	}
	public static void mergeSort(int[] a, int[] tempArray, int first, int last) {
		if(first<last) {
			int mid = (first + last) / 2;
			mergeSort(a, tempArray, first, mid);
			mergeSort(a, tempArray, mid+1, last);
			if(a[mid]>a[mid+1])//当左边数组值全部小于或者等于右边数据，则不需要归并
				merge(a, tempArray, first, mid, last);
		}
	}

	private static void merge(int[] a, int[] tempArray, int first, int mid, int last) {
		int leftBegin = first;
		int leftEnd = mid;
		int rightBegin = mid + 1;
		int rightEnd = last;
		int index = first;
		//比较两个子数组，按从小到大的顺序将数据拷贝到临时数组
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
		//将一个数组中剩下的值拷贝到临时数组
		if(leftBegin>leftEnd) {// 左数组已经全部复制
			//将右边剩余项复制到数组
			for(int i=rightBegin;i<=rightEnd;i++) {
				tempArray[index++] = a[i];
			}
		}
		if(rightBegin>rightEnd) {//右数组已经全部复制
			//将左边剩余项复制到数组
			for(int i=leftBegin;i<=leftEnd;i++)
				tempArray[index++] = a[i];
		}
		//将临时数组拷贝到原数组
		for(int i=first;i<index;i++)
			a[i] = tempArray[i];
	}
	private static void swap(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
