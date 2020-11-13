package com.dhb.factory;

public class Main {

	public static void main(String[] args) {
		Moveable m = CarFactory.createCar();
		m.go();
	}
}
