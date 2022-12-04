package com.company.functionalinterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
  public static void main(String[] args) {
    UnaryOperator<Integer> unaryOperator = x -> x * 10;
    // 5 * 10
    System.out.println(unaryOperator.apply(5));

    UnaryOperator<Integer> unaryOperator1 = x -> x + 5;
    // 5 * 10 = 50 + 5 = 55
    System.out.println(unaryOperator.andThen(unaryOperator1).apply(5));
  }
}
