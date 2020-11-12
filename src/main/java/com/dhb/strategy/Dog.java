package com.dhb.strategy;

public class Dog implements Comparable<Dog> {

	int food;

	public Dog(int weight) {
		this.food = weight;
	}

	@Override
	public int compareTo(Dog c) {
		if(this.food < c.food) {
			return -1;
		}else if(this.food > c.food) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Dog{" +
				"food=" + food +
				'}';
	}
}
