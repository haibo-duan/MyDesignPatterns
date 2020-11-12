package com.dhb.singleton;


import java.util.stream.IntStream;

/**
 * 采用枚举来实现单例
 * 不仅可以解决线程同步问题，还可以防止反序列化。
 * 枚举类由于没有构造方法，因此不能够根据class反序列化之后实例化。因此这种写法是最完美的单例模式。
 * 枚举是java中约定的特殊格式，因此不需要构造函数。
 */
public class Mgr08 {

	private Mgr08() {
	}

	public static Mgr08 getInstance() {
		return Sigleton.INSTANCE.getInstance();
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr08.getInstance().hashCode())).start();
		});
	}

	public void m() {
		System.out.println("m");
	}

	private enum Sigleton {
		INSTANCE;

		private final Mgr08 instance;

		Sigleton() {
			instance = new Mgr08();
		}
		public Mgr08  getInstance() {
			return instance;
		}
	}


}
