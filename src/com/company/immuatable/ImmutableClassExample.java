package com.company.immuatable;

import java.util.ArrayList;
import java.util.List;

final class ImmutableClass {
  private final int a;
  private final String b;
  private final double c;
  private final char d;
  private final List<String> list;

  ImmutableClass(int a, String b, double c, char d, List<String> list) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.list = new ArrayList<>(list);
  }

  public int getA() {
    return a;
  }

  public String getB() {
    return b;
  }

  public double getC() {
    return c;
  }

  public char getD() {
    return d;
  }

  public List<String> getList() {
    return new ArrayList<>(list);
  }
}

public class ImmutableClassExample {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("abx");
    list.add("sdf");
    list.add("dfhfh");
    ImmutableClass immutableClass =new ImmutableClass(1,"name",12.34,'a', list);
    System.out.println(immutableClass.getList());
    immutableClass.getList().add("sdgdtgdh");
    System.out.println(immutableClass.getList());
  }
}
