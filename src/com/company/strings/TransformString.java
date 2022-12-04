package com.company.strings;

import java.util.Map;

public class TransformString {
  public static void main(String[] args) {
    String s = "abcd;lt;qwer;gt;asd;";
    Map<String, String> map = Map.of(";lt;", "<", ";gt;", ">");

    StringBuilder sb = new StringBuilder(s);
    for (Map.Entry<String, String> entry : map.entrySet()) {
      String k = entry.getKey();
      String v = entry.getValue();
      int index = sb.indexOf(k);
      while (index != -1) {
        int endIndex = index + k.length();
        sb.delete(index, endIndex);
        sb.insert(index, v);
        index = sb.indexOf(k);
      }
    }
    System.out.println(sb);
  }
}
