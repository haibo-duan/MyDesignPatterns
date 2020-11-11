package com.dhb.singleton;

/**
 * 懒汉式单例模式
 * 简单实用，线程安全。可以推荐使用
 * 唯一缺点是不管用到与否，在类加载的时候都会进行实例化。
 */
public class Mgr01 {

	private static final Mgr01 INSTANCE = new Mgr01();

	private Mgr01() {}

	public static Mgr01 getInstance(){
		return INSTANCE;
	}

	public void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		Mgr01 m1 = Mgr01.getInstance();
		Mgr01 m2 = Mgr01.getInstance();
		System.out.println(m1 == m2);
	}
}
