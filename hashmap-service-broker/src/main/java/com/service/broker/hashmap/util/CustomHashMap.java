package com.service.broker.hashmap.util;

import org.springframework.stereotype.Component;
/**
 * \
 * @author aditya.gupta2
 *
 * @param <K>
 * @param <V>
 */
@Component
public class CustomHashMap<K, V> implements CustomHashMapApi<K, V> {

	private static final Integer INITIAL_CAPACITY = 50;
	private CustomEntry<K, V>[] table;

	static class CustomEntry<K, V> {
		K key;
		V value;
		CustomEntry<K, V> next;

		public CustomEntry(K key, V value, CustomEntry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	/**
	 * Method allows you put key-value pair in HashMapCustom. If the map already
	 * contains a mapping for the key, the old value is replaced. Note: method
	 * does not allows you to put null key though it allows null values
	 */
	@Override
	public void put(K key, V value) {
		if (key == null)
			return; // does not allow to store null.
		// calculate hash of key.
		int hash = hash(key);
		// create new entry.
		CustomEntry<K, V> newEntry = new CustomEntry<K, V>(key, value, null);
		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			CustomEntry<K, V> previous = null;
			CustomEntry<K, V> current = table[hash];
			while (current != null) { // we have reached last entry of bucket.
				if (current.key.equals(key)) {
					if (previous == null) { // node has to be insert on first of
											// bucket.
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}

	}

	/**
	 * 
	 */
	@Override
	/**
	 * get the value V of the key k
	 */
	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			CustomEntry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next; // return value corresponding to key.
			}
			return null; // returns null if key is not found.
		}
	}

	@Override 
	/**
	 * remove the key k
	 */
	public boolean remove(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return false;
		} else {
			CustomEntry<K, V> previous = null;
			CustomEntry<K, V> current = table[hash];

			while (current != null) { // we have reached last entry node of
										// bucket.
				if (current.key.equals(key)) {
					if (previous == null) { // delete first entry node.
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}

	@Override
	public void display() {
		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			if (table[i] != null) {
				CustomEntry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}
	}

	/**
	 * Method implements hashing functionality, which helps in finding the
	 * appropriate bucket location to store our data. This is very important
	 * method, as performance of CustomHashMap is very much dependent on this
	 * method's implementation.
	 * 
	 * @param key
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
	}
}
