package com.test;

record M(int a, int b) {

}
public class Test {

  public static void main(String[] args) {
    M a =new M(5, 10);
    System.out.println(a);
  }
}
