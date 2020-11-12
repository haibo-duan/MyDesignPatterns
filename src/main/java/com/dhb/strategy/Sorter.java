package com.dhb.strategy;

/**
 * 当sort方法支持int类型之后
 * 如果要扩展为float double 甚至类进行排序，应该如何处理？
 * 如果一个个添加方法，那么将会非常被动。
 * 此时需要用到策略模型。
 */
public class Sorter {

	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

	}

	private static void swap(Comparable[] arr, int i, int j) {
		if (i != j) {
			Comparable tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

	}

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				minPos = arr[j] < arr[minPos] ? j : minPos;
			}
			swap(arr, i, minPos);
		}
	}

	public void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				minPos = arr[j].compareTo(arr[minPos]) < 0 ? j : minPos;
			}
			swap(arr, i, minPos);
		}
	}

}
