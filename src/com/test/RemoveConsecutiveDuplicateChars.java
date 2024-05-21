package com.test;

public class RemoveConsecutiveDuplicateChars {

  static void process(String s) {
    char ch[] = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<ch.length;i++) {
      if(i==0 || ch[i] != ch[i-1]) {
        sb.append(ch[i]);
      }
    }

    System.out.println(sb);
  }

  public static void main(String[] args) {
    process("aabcdeeefgghijkllllmnn");
    // output - abcdefghijklmn
  }
}
