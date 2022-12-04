package com.company;

public class MemoryDemo {
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    System.out.println("total : " + runtime.totalMemory());
    System.out.println("max : " + runtime.maxMemory());
    System.out.println("free : " + runtime.freeMemory());
  }
}
