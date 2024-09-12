package com.capx.dmcs;


public class CacheSystemTest {

	public static void main(String[] args) {

		MultiLevelCache cache = new MultiLevelCache();

		 // Add cache levels
        System.out.println("Adding cache levels:");
        cache.addCacheLevel(3, "LRU");  // L1 Cache (size: 3, policy: LRU)
        cache.addCacheLevel(2, "LFU");  // L2 Cache (size: 2, policy: LFU)
        
        // Test insertion
        System.out.println("\nInserting data into cache:");
        cache.put("A", "1");
        cache.put("B", "2");
        cache.put("C", "3");
        
        System.out.println("After inserting A, B, C:");
        cache.displayCache();
        
        // Test LRU eviction (L1 Cache is full)
        cache.put("D", "4");  // Evicts least recently used in L1
        System.out.println("\nAfter inserting D (LRU eviction should occur):");
        cache.displayCache();
        
        // Test data retrieval
        System.out.println("\nRetrieving data:");
        System.out.println("Get A: " + cache.get("A"));  // A is evicted, expect null
        System.out.println("Get B: " + cache.get("B"));  // B is in L1
        System.out.println("Get C: " + cache.get("C"));  // C is in L1
        
        // Test LFU eviction in L2
        cache.put("E", "5");  // L2 Cache is now full
        cache.put("F", "6");  // LFU eviction should occur in L2
        System.out.println("\nAfter inserting E and F (LFU eviction in L2):");
        cache.displayCache();
        
        // Remove a cache level
        System.out.println("\nRemoving L2 Cache:");
        cache.removeCacheLevel(2);  // Remove L2 cache
        cache.displayCache();
	}
}