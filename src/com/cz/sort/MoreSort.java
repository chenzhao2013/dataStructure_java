package com.cz.sort;

/**
 * ①快速排序 平均是O(nlogn)
 * ②归并排序 一直是O(nlogn)
 * @author ChenZhao
 *
 */
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
}
