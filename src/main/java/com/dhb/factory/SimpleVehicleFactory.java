package com.dhb.factory;

public class SimpleVehicleFactory {


	public Car createCar() {
		return new Car();
	}

	public Train createTrain() {
		return new Train();
	}

	public Plan createPlan() {
		return new Plan();
	}

	public Broom createBroom() {
		return new Broom();
	}
}
