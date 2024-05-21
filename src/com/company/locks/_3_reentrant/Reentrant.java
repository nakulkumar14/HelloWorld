package com.company.locks._3_reentrant;

public class Reentrant {
  public synchronized void outer() {
    inner();
  }

  public synchronized void inner() {
    // do something
  }
}
