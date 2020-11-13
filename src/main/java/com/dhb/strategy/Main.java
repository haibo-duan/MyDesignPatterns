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

		Dog[] d1 = {new Dog(3),new Dog(5),new Dog(1),new Dog(8)};
		NewSorter<Dog> sort1 = new NewSorter<>();
		DogComparator dogComparator = new DogComparator();
		sort1.sort(d1,dogComparator);
		System.out.println(Arrays.toString(d1));

		Cat[] c = {new Cat(3,4),new Cat(2,5),new Cat(1,7),new Cat(8,1)};
		NewSorter<Cat> catSort = new NewSorter<>();
		catSort.sort(c,(o1,o2)-> {
			if(o1.weight < o2.weight){
				return -1;
			}
			if(o1.weight < o2.weight){
				return 1;
			}
			return 0;
		});
		System.out.println(Arrays.toString(c));
	}
}
