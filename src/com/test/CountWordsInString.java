package com.test;

public class CountWordsInString {

  int countWords(String s) {
    int count = 0;
    int in = 0;
    for (int i = 0; i < s.length(); i++) {

      if (Character.isAlphabetic(s.charAt(i))) {
        if (i - 1 >= 0 && s.charAt(i - 1) == '\\' && (s.charAt(i) == 'n' || s.charAt(i) == 't')) {
          count++;
        } else {
          in++;
        }
      } else if (Character.isSpaceChar(s.charAt(i)) && in > 0) {
        in = 0;
        count++;
      } else if (s.charAt(i) == '\\' && (s.charAt(i + 1) == 'n' || s.charAt(i + 1) == 't')) {
        if (in > 0) {
          in = 0;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    CountWordsInString o = new CountWordsInString();
//    System.out.println(o.countWords("a\\nhjpfo"));
    System.out.println(o.countWords(" m  hp"));
  }
}
