package com.dhb.strategy;

public class Cat implements Comparable<Cat>{
	int weight,hight;

	public Cat(int weight, int hight) {
		this.weight = weight;
		this.hight = hight;
	}


	@Override
	public int compareTo(Cat c) {
		if(this.weight < c.weight) {
			return -1;
		}else if(this.weight > c.weight) {
			return 1;
		}else {
			return 0;
		}
	}
}
