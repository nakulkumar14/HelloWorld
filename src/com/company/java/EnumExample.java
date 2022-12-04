package com.company.java;

enum Color { BLACK, WHITE };
enum Chiral { LEFT, RIGHT };

public class EnumExample {
  public static void main(String[] args) {
    if (Color.BLACK.equals(Chiral.LEFT)); // compiles fine
//    if (Color.BLACK == Chiral.LEFT);      // DOESN'T COMPILE!!! Incompatible types!
  }
}
