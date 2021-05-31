package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bike");
        list.add("scooter");
        list.add("car");
        list.add("cycle");


        System.out.println(list.size());

        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals("car")){
                list.remove(i);
            }
        }

        for(String s : list) {
            if (s.equals("car")){
                list.remove(s);
            }
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("car"))
                iterator.remove();
        }

        System.out.println(list.size());
    }
}
