package com.dhb.strategy;

/**
*@author haibo.duan 采取策略模式实现
*@description
*@date  2020/11/12 20:39
*/
public class NewSorter<T> {

	public void sort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				minPos = comparator.compare(arr[j],arr[minPos]) == 1 ? j : minPos;
			}
			swap(arr, i, minPos);
		}
	}

	private void swap(T[] arr,int i,int j) {
		if (i != j) {
			T tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}

}
