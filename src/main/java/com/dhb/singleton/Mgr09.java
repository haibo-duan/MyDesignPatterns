package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例
 * mgr06 单例实际仍然存在问题:
 *  那就是类初始化仍然需要时间，如果同时又两个线程同时进入getInstance方法，
 *  第一个线程锁定之后，第二个线程判断不为空，则直接使用instalce,
 *  如果此时第一个线程对Mgr03对象还没实例化完成，如该对象内部存在一个耗时的引用，如果是一个数据库连接，
 *  则会导致第二个线程使用的对象不完整。出现空指针。因此更好的写法是加上volatile。以保证happen-before原则。
 *
 *  JIT编译器 进行JIT优化之后，会有很多的指令重排序，因此需要加volatile。但是这种方法还是不能够避免反序列化。
 */
public class Mgr09 {

	private volatile static Mgr09 INSTANCE;

	private Mgr09() {}

	public static Mgr09 getInstance() {
		//双重检查 第一次判断不能省去 可以拦截大部分无用调用
		if(INSTANCE == null) {
			synchronized (Mgr09.class) {
				if(INSTANCE == null) {
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Mgr09();
				}
			}
		}
		return INSTANCE;
	}

	public static void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr09.getInstance().hashCode())).start();
		});
	}
}
