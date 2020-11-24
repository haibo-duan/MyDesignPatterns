package com.dhb.proxy.v8;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

interface Movable {
	void move();
}

public class Tank implements Movable {

	public static void main(String[] args) {
		Tank tank = new Tank();
		Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
				new Class[]{Movable.class},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("method " + method.getName() + " start ...");
						Object o = method.invoke(tank, args);
						System.out.println("method " + method.getName() + "  end ");
						return o;
					}
				}
		);
		m.move();
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moveing claclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}