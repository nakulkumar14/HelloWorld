package com.company;

import java.util.ArrayList;
import java.util.List;

public class KeypadStrings {
  List<String> getAllCombinations(String nums) {

    List<String> result = new ArrayList<>();
    result.add("");
    String[] map = {"","abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};

    for (int i = 0; i < nums.length(); i++) {
      List<String> list = new ArrayList<>();
      int digit = nums.charAt(i)-'0';
      for (char c : map[digit].toCharArray()) {
        for (int j = 0; j < result.size(); j++) {
          list.add(result.get(j) + c);
        }
      }
      result = list;
    }
    return result;
  }

  public static void main(String[] args) {
    KeypadStrings k = new KeypadStrings();
    System.out.println(k.getAllCombinations("12"));
  }
}
