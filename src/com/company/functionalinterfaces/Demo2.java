package com.company.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Demo2 {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,4,5,6,8);

    Predicate<Integer> p = (i) -> i%2==0;
    System.out.println("predicate ---");
    list.forEach(i-> {
      if (p.test(i))
        System.out.print(i + " ");
    });

    System.out.println("supplier ---");
    Supplier<String> supplier = () -> "hi";
    System.out.println(supplier.get());

    System.out.println("consumer ---");
    Consumer<String> consumer = (s -> System.out.println("hello " + s));
    consumer.accept("mac");

    System.out.println("binary operator ---");
    BinaryOperator<String> binaryOperator = ((s1, s2) -> s1 + s2);
    System.out.println(binaryOperator.apply("hi","bye"));
    binaryOperator = ((a,b) -> String.valueOf(a.length() + b.length()));
    System.out.println(binaryOperator.apply("ab","cd"));

    System.out.println("unary operator ---");
    UnaryOperator<Integer> unaryOperator = (integer -> integer + 10);
    System.out.println(unaryOperator.apply(5));

    System.out.println("doubleToIntFunction ---");
    DoubleToIntFunction doubleToIntFunction = d -> (int)d;
    System.out.println(doubleToIntFunction.applyAsInt(10l));

    System.out.println("toDoubleBiFunction ---");
    ToDoubleBiFunction<String, Integer> toDoubleBiFunction = (s, i) ->  Double.parseDouble(s) + i;
    System.out.println(toDoubleBiFunction.applyAsDouble("10", 10));
  }
}
