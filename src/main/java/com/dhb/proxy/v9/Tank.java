package com.dhb.proxy.v9;


import org.omg.CORBA.portable.InvokeHandler;

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
				new TimeProxy(tank)
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

class TimeProxy implements InvocationHandler {
	Movable m;

	public TimeProxy(Movable m) {
		this.m = m;
	}

	public void before() {
		System.out.println("method start..");
	}

	public void after() {
		System.out.println("method stop..");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object o = method.invoke(m,args);
		after();
		return o;
	}
}