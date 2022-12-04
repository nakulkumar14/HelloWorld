package com.company;

import java.util.ArrayList;
import java.util.List;

class G1 extends G{
  int a = 10;
  public G1() {
  }
}

class G2 extends G {
  float b = 2.4f;
  public G2() {
  }
}

class G {
  public G() {
  }
}

class A1 {
  public A1() {
  }
}

class A2 extends A1{
  public A2() {
  }
}

public class Generic1 {
  public static void main(String[] args) {
    List<? extends G> gs = List.of(new G1(), new G2());
    System.out.println(((G1)gs.get(0)).a);
    System.out.println(((G2)gs.get(1)).b);


    List<? super A1> as = new ArrayList<>();
    A1 a1 = new A1();
    as.add(a1);
  }
}
