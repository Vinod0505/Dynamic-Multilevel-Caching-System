package com.capx.dmcs;

import java.util.LinkedHashMap;

class LRUCacheLevel extends CacheLevel {
	
	private LinkedHashMap<String, CacheEntry> cache;

	LRUCacheLevel(int size) {
		super(size, "LRU");
		this.cache = new LinkedHashMap<>(size, 0.75f, true); // true enables access-order
	}

	@Override
	String get(String key) {
		if (cache.containsKey(key)) {
			return cache.get(key).value;
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		if (cache.size() >= size) {
			evict();
		}
		cache.put(key, new CacheEntry(key, value));
	}

	@Override
	void evict() {
		String oldestKey = cache.keySet().iterator().next();
		cache.remove(oldestKey);
	}

	@Override
	void displayCache() {
		System.out.println("LRU Cache: " + cache.values());
	}
}