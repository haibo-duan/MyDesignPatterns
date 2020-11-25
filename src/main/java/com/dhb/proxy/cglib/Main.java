package com.dhb.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Tank.class);
		enhancer.setCallback(new TimeMethodInterceptor());
		Tank tank = (Tank) enhancer.create();
		tank.move();
	}
}

class TimeMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println(o.getClass().getSuperclass().getClass());
		System.out.println("before");
		Object result = null;
		result = methodProxy.invokeSuper(o,objects);
		System.out.println("after");
		return result;
	}
}

class Tank {
	public void move() {
		System.out.println("tank moving claclaclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
