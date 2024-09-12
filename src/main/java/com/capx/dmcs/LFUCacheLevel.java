package com.capx.dmcs;

import java.util.HashMap;
import java.util.Map;

class LFUCacheLevel extends CacheLevel {
	
    private HashMap<String, CacheEntry> cache;
    private HashMap<String, Integer> frequencyMap;

    LFUCacheLevel(int size) {
        super(size, "LFU");
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    @Override
    String get(String key) {
        if (cache.containsKey(key)) {
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
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
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
    }

    @Override
    void evict() {
        String lfuKey = null;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFreq) {
                minFreq = entry.getValue();
                lfuKey = entry.getKey();
            }
        }

        cache.remove(lfuKey);
        frequencyMap.remove(lfuKey);
    }

    @Override
    void displayCache() {
        System.out.println("LFU Cache: " + cache.values());
    }
}