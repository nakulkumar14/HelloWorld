package com.company.lrucache.map;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> {
    LinkedHashMap<K, V> map;
    LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    V get(K key) {
        return map.getOrDefault(key, null);
    }

    void put(K key, V value) {
        map.put(key, value);
    }
}

public class LRUCacheLinkedHashMap {
    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(2);
        lruCache.put("apple", "juice");
        lruCache.put("mango", "shake");
        System.out.println(lruCache.get("grape"));
        System.out.println(lruCache.get("apple"));
        System.out.println(lruCache.get("mango"));
        lruCache.put("grape", "wine");
        System.out.println(lruCache.get("grape"));
    }
}
