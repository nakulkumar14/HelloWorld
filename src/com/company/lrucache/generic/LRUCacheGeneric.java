package com.company.lrucache.generic;

import java.util.HashMap;
import java.util.Map;

class LRUNode<K, V> {
    K key;
    V value;
    LRUNode prev, next;

    LRUNode(K k, V v) {
        key = k;
        value = v;
    }
}

class LRUCache<K, V> {
    int count;
    int capacity;
    LRUNode<K, V> head, tail;
    Map<K, LRUNode<K, V>> map;

    LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new LRUNode(null, null);
        tail = new LRUNode(null, null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    void addToHead(LRUNode<K, V> lruNode) {
        lruNode.next = head.next;
        lruNode.next.prev = lruNode;

        head.next = lruNode;
        lruNode.prev = head;
    }

    void deleteNode(LRUNode<K, V> lruNode) {
        lruNode.prev.next = lruNode.next;
        lruNode.next.prev = lruNode.prev;
    }

    V get(K key) {
        if (map.containsKey(key)) {
            LRUNode<K, V> node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    void put(K key, V value) {
        if (map.containsKey(key)) {
            LRUNode<K, V> node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            LRUNode<K, V> node = new LRUNode<>(key, value);
            if (count < capacity) {
                count++;
            } else {
                // remove eldest entry.
                LRUNode eldest = tail.prev;
                map.remove(eldest.key);
                deleteNode(eldest);
            }
            addToHead(node);
            map.put(key, node);
        }
    }
}

public class LRUCacheGeneric {
    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache(2);
        lruCache.put("red", 1);
        lruCache.put("blue", 4);
        System.out.println(lruCache.get("red"));
        lruCache.put("green", 3);
        System.out.println(lruCache.get("red"));
        System.out.println(lruCache.get("blue"));

        System.out.println("\n");
        LRUCache<Integer, Double> cache = new LRUCache(2);
        cache.put(5, 5.75);
        cache.put(2, 2.5);
        cache.put(3, 3.62);
        System.out.println(cache.get(5));
        System.out.println(cache.get(3));
        "".indexOf(' ');
    }
}
