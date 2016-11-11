package com.spring.cloud.hashmap.broker.util;

/**
 * 
 * @author aditya.gupta2
 *
 * @param <K>
 * @param <V>
 */
public interface CustomHashMapApi<K, V> {

	public void put(K key, V value);

	public V get(K key);

	public boolean remove(K key);

	public void display();
}
