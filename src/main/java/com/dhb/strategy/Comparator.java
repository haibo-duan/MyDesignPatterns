package com.dhb.strategy;

/**
 * 增加排序策略
 * @param <T>
 */
public interface Comparator<T> {

	int compare(T o1,T o2);
}
