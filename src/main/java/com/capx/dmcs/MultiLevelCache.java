package com.capx.dmcs;

import java.util.ArrayList;
import java.util.List;

public class MultiLevelCache {

	private List<CacheLevel> cacheLevels;

	MultiLevelCache() {
		this.cacheLevels = new ArrayList<>();
	}

	void addCacheLevel(int size, String evictionPolicy) {
		CacheLevel newLevel;
		if (evictionPolicy.equalsIgnoreCase("LRU")) {
			newLevel = new LRUCacheLevel(size);
		} else if (evictionPolicy.equalsIgnoreCase("LFU")) {
			newLevel = new LFUCacheLevel(size);
		} else {
			throw new IllegalArgumentException("Unsupported eviction policy: " + evictionPolicy);
		}
		cacheLevels.add(newLevel);
	}

	void removeCacheLevel(int level) {
		if (level >= 1 && level <= cacheLevels.size()) {
			cacheLevels.remove(level - 1);
		} else {
			throw new IllegalArgumentException("Invalid cache level: " + level);
		}
	}

	String get(String key) {
		for (CacheLevel level : cacheLevels) {
			String value = level.get(key);
			if (value != null) {
				promoteToL1(key, value);
				return value;
			}
		}
		return null;
	}

	void put(String key, String value) {
		cacheLevels.get(0).put(key, value);
	}

	private void promoteToL1(String key, String value) {
		cacheLevels.get(0).put(key, value);
	}

	void displayCache() {
		int level = 1;
		for (CacheLevel cacheLevel : cacheLevels) {
			System.out.println("Level " + level + ": ");
			cacheLevel.displayCache();
			level++;
		}
	}
}