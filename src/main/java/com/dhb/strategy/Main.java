package com.dhb.strategy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] a = {9,2,3,5,7,1,4};
		Sorter sorter = new Sorter();
		sorter.sort(a);
		System.out.println(Arrays.toString(a));

		Dog[] d = {new Dog(3),new Dog(5),new Dog(1),new Dog(8)};
		sorter.sort(d);
		System.out.println(Arrays.toString(d));
	}
}
