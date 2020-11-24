package com.dhb.proxy.v7;


import java.util.Random;
import java.util.concurrent.TimeUnit;

interface Movable{
	void move();
}

public class Tank implements Movable {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moveing claclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main(String[] args) {
		new TankTimeProxy(new TankLogProxy(new Tank())).move();
	}
}

class TankTimeProxy implements Movable {
	Movable move;

	public TankTimeProxy(Movable move) {
		this.move = move;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		move.move();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}

class TankLogProxy implements Movable {
	Movable move;

	public TankLogProxy(Movable move) {
		this.move = move;
	}

	@Override
	public void move() {
		System.out.println("start moving ...");
		move.move();
		System.out.println("stopped");
	}
}