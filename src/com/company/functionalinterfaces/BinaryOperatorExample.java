package com.company.functionalinterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
  public static void main(String[] args) {
    BinaryOperator<Integer> binaryOperator = (x,y) -> x + y;
    System.out.println(binaryOperator.apply(5, 10));

    BinaryOperator<Boolean> binaryOperator1 = (x,y) -> x && y;
    System.out.println(binaryOperator1.apply(false, true));
  }
}
