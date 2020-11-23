package com.dhb.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bulletpool {
	List<Bullet> bullets = new ArrayList<>();
	{
		for(int i=0;i<5;i++) {
			bullets.add(new Bullet());
		}
	}

	public Bullet getBullet() {
		for(int i=0;i<bullets.size();i++) {
			Bullet b = bullets.get(i);
			if(!b.living) {
				return b;
			}
		}
		return new Bullet();
	}

	public static void main(String[] args) {
		Bulletpool bp = new Bulletpool();
		for(int i=0;i<10;i++) {
			Bullet b = bp.getBullet();
			System.out.println(b);
		}
	}

}

class Bullet{

	public UUID id = UUID.randomUUID();
	boolean living = true;

	@Override
	public String toString() {
		return "Bullet{" +
				"id=" + id +
				", living=" + living +
				'}';
	}
}
