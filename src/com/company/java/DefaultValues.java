package com.company.java;

class Default {
  int i;
  float j;
  char c;
  String a;

  public void show() {
    int x;
    System.out.println(i);
//    System.out.println(x);
  }
}

public class DefaultValues {
  public static void main(String[] args) {
    Default d = new Default();
    d.show();
  }
}
