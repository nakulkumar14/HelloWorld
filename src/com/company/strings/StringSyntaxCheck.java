package com.company.strings;

import java.util.Arrays;
import java.util.List;

public class StringSyntaxCheck {

  static boolean validate(String sentence) {
    char[] c = sentence.toCharArray();
    int i = 0;
    if (Character.isLowerCase(c[i])) {
      return false;
    }
    if (c[c.length - 1] != '.') {
      return false;
    }
    while (i < c.length) {
      if (i + 1 < c.length && c[i] == ' ' && c[i + 1] == ' ') {
        return false;
      }
      if (i + 1 < c.length && Character.isUpperCase(c[i]) && Character.isUpperCase(c[i + 1])) {
        return false;
      }
      if (i - 1 >= 0 && Character.isUpperCase(c[i]) && c[i - 1] != ' ') {
        return false;
      }
      i++;
    }
    return true;
  }

  public static void main(String[] args) {
    List<String> sentences = Arrays.asList(
        "This sentence is syntactically correct.",

        "This sentence is syntactically  incorrect as two " +
            "continuous spaces are not allowed.",

        "This sentence is syntactically correct Y.",

        "This sentence is syntactically incorRect as uppercase " +
            "character is not allowed midway of the String.",

        "THis sentence is syntactically incorrect as two " +
            "continuous uppercase characters are not allowed.",

        "This sentence is syntactically incorrect as it doesn't " +
            "end with a full stop"
    );

    for (String sentence : sentences) {
      if (validate(sentence))
        System.out.println(sentence);
    }

  }
}
