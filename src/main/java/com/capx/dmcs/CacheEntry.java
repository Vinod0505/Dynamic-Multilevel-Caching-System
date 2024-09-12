package com.capx.dmcs;

public class CacheEntry {

	String key;
	String value;

	CacheEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return key + ": " + value;
	}
}
