package com.company.java;

import java.util.ArrayList;
import java.util.List;

public class MemoryOverflow {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    while (true) {
      list.add(new String("hi"));
    }
  }
}
