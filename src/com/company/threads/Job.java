package com.company.threads;

public interface Job extends Runnable{
  void execute();

  @Override
  default void run() {
    execute();
  }
}
