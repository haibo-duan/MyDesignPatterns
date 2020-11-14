package com.dhb.abstractfactory;

public class ModenFactory extends AbstractFactory{

	@Override
	Food createFood() {
		return new Bread();
	}

	@Override
	Vehicle createVehicle() {
		return new Car();
	}

	@Override
	Weapon createWeapon() {
		return new Ak47();
	}
}
