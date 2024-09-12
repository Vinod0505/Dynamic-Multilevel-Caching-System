package com.capx.dmcs;

abstract class CacheLevel {
	
	int size;
	String evictionPolicy;

	CacheLevel(int size, String evictionPolicy) {
		this.size = size;
		this.evictionPolicy = evictionPolicy;
	}

	abstract String get(String key);  // Fetch data
	abstract void put(String key, String value);  // Insert data
	abstract void evict();  // Evict based on the eviction policy
	abstract void displayCache();  // Show cache contents
}

