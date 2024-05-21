package com.test;

import java.util.HashSet;
import java.util.Stack;

public class StackTest {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.add(i);
      } else if (c == ')') {
        if (stack.size() > 0 && s.charAt(stack.peek()) == '(') {
          stack.pop();
        } else {
          stack.add(i);
        }
      }
    }
    StringBuilder sb = new StringBuilder();

    HashSet<Integer> set = new HashSet<>(stack);
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(i)) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    StackTest o = new StackTest();
//    System.out.println(o.minRemoveToMakeValid("lee(t(c)o)de)"));
//    System.out.println(o.minRemoveToMakeValid("a)b(c)d"));
    System.out.println(o.minRemoveToMakeValid("))(("));
  }
}
