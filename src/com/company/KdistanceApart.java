package com.company;

import java.util.*;

public class KdistanceApart {

    public String rearrangeString(String str, int k) {
        Map<Character, Integer> map =new HashMap<>();
        for (char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> q = new PriorityQueue<>((c1, c2) -> {
            if(map.get(c2)!=map.get(c1)){
                return map.get(c2)-map.get(c1);
            }else{
                return c1.compareTo(c2);
            }
        });

        for (char c : map.keySet()) {
            q.offer(c);
        }

        System.out.println(q);

        StringBuilder s = new StringBuilder();

        int len = str.length();
        while (!q.isEmpty()) {
            ArrayList<Character> list = new ArrayList<>();

            int count = Math.min(k, len);
            System.out.println(count + " " + len);
            for (int i = 0; i < count; i++) {

                if (q.isEmpty())
                    return "";

                Character poll = q.poll();
                s.append(poll);
                System.out.println("s " + s);

                map.put(poll, map.get(poll) - 1);

                if (map.get(poll) > 0) {
                    list.add(poll);
                }
                len--;
            }

            for (char c : list){
                q.offer(c);
            }

        }

        return s.toString();
    }

    public static void main(String[] args) {
        KdistanceApart o = new KdistanceApart();
        System.out.println(o.rearrangeString("aabbcc", 3));
    }
}
