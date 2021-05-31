package com.company.lrucache;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int val;
    LRUNode next, prev;

    LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {


    int size;
    int count;
    Map<Integer, LRUNode> map = new HashMap<>();
    LRUNode head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        count = 0;
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(LRUNode temp) {
        temp.next = head.next;
        temp.next.prev = temp;
        temp.prev = head;
        head.next = temp;
    }

    public void deleteNode(LRUNode temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        LRUNode temp = map.get(key);
        deleteNode(temp);
        addToHead(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode temp = map.get(key);
            temp.val = value;   // update value.
            deleteNode(temp);
            addToHead(temp);
        } else {
            LRUNode temp = new LRUNode(key, value);
            if (count < size) {
                count++;
                addToHead(temp);
            } else {
                LRUNode eldest = tail.prev;
                map.remove(eldest.key);
                deleteNode(eldest);
                addToHead(temp);
            }
            map.put(temp.key, temp);
        }
    }
}

public class LruCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}