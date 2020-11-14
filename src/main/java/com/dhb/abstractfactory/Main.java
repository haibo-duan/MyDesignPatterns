package com.dhb.abstractfactory;

import com.dhb.factory.CarFactory;
import com.dhb.factory.Moveable;

public class Main {

	public static void main(String[] args) {
//		Car c = new Car();
//		c.go();
//		Ak47 ak47 = new Ak47();
//		ak47.shoot();
//		Bread bread = new Bread();
//		bread.printName();
//
//		Broom b = new Broom();
//		b.go();
//		MagicStick m = new MagicStick();
//		m.shoot();
//		MushRoom mu = new MushRoom();
//		mu.printName();

		ModenFactory m = new ModenFactory();
		Food food = m.createFood();
		Vehicle vehicle = m.createVehicle();
		Weapon weapon = m.createWeapon();
		food.printName();
		vehicle.go();
		weapon.shoot();

	}
}
