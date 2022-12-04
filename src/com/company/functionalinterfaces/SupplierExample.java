package com.company.functionalinterfaces;

import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class SupplierExample {
  public static void main(String[] args) {

    List<String> list = List.of("adam", "eve", "paris", "mango", "apple");
    Supplier<Optional<String>> supplier = () -> list.stream()
        .filter(s -> s.length() > 4)
        .findFirst();

    Optional<String> optional = supplier.get();
    optional.ifPresent(System.out::println);

    /////////////////////////////////////////////////////////

    BooleanSupplier booleanSupplier = () -> list.size() > 4;
    System.out.println(booleanSupplier.getAsBoolean());

    /////////////////////////////////////////////////////////


  }
}
