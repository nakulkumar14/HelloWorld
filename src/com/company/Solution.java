package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        System.out.println(map);

        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = s.length()+1;
        int minLeft = 0;

        for (right = 0; right < s.length() ; right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }

                System.out.println("count " + count + ", map " + map);

                while (count == t.length()) {
                    System.out.println("right " + right + " left " + left + " minLen " + minLen  + " minLeft " + minLeft);
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right-left+1;
                    }

                    if (map.containsKey(s.charAt(left))) {
                        System.out.println("left " + left + " count " + count + " map " + map);
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left))>0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if (s.length() < minLen) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.minWindow("ADOBECODEBANC","ABC"));
    }
}