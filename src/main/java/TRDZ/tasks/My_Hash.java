package TRDZ.tasks;

import java.util.ArrayList;

public class My_Hash<K, V> {

	private final ArrayList<Item<K,V>>[] data;
	private int size;

	public My_Hash() {
		this(16);
		}

	public My_Hash(int initialCapacity) {
		data = new ArrayList[initialCapacity*2];
		}

	public boolean put(K key, V value) {
		if (size() == data.length) return false;
		int index = hashFunc(key);
		int attempt=0;
		if (data[index]==null) data[index]=new ArrayList<Item<K,V>>();
		if (data[index].size() > 0) {
			do {// while ( attempt>=size );
				if (isKeysEquals(data[index].get(attempt), key)) {
					data[index].get(attempt).setValue(value);
					return true;
					}
				attempt++;
				} while ( attempt<data[index].size() );
			size--;
			}
		data[index].add(new Item<>(key, value));
		size++;
		return true;
		}

	private boolean isKeysEquals(Item<K, V> item, K key) {
		return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
		}

	private int hashFunc(K key) {
		return Math.abs(key.hashCode() % data.length);
		}

	private int indexOf(K key, int index) {
		if (data[index] == null) return -1;
		int attempt = 0;
		while (attempt < data[index].size()) {
			if (isKeysEquals(data[index].get(attempt), key)) return attempt;
			attempt++;
			}
		return -1;
		}

	public V get(K key) {
		int index = hashFunc(key);
		int attempt = indexOf(key,index);
		return attempt == -1 ? null : data[index].get(attempt).getValue();
		}

	public V remove(K key) {
		int index = hashFunc(key);
		int attempt = indexOf(key,index);

		if (attempt == -1) return null;
		Item<K, V> removed = data[index].get(attempt);
		data[index].remove(attempt);
		if (data[index].size()==0) size--;
		return removed.getValue();
		}

	public int size() {
		return size;
		}

	public boolean isEmpty() {
		return size == 0;
		}

	public void display() {
		System.out.println(this);
		}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) sb.append(String.format("%s = %s%n", i, data[i]));
		return sb.toString();
		}

	static class Item<K, V> {
		private final K key;
		private V value;

		public Item(K key, V value) {
			this.key = key;
			this.value = value;
			}

		public K getKey() {
			return key;
			}

		public V getValue() {
			return value;
			}

		public void setValue(V value) {
			this.value = value;
			}

		@Override
		public String toString() {
			return  "Объект " + key + ", цена=" + value + '}';
			}
		}


	}
