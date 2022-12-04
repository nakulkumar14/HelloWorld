package com.company.singleton;

class SingletonThreadSafe {

  private static SingletonThreadSafe obj = null;

  private SingletonThreadSafe() {

  }

  public static synchronized SingletonThreadSafe getInstance() {
    if (obj == null) {
      obj = new SingletonThreadSafe();
    }
    return obj;
  }
}

class SingletonThreadSafeOpt {
  private static SingletonThreadSafeOpt obj = null;

  private SingletonThreadSafeOpt() {

  }

  public static SingletonThreadSafeOpt getInstance() {
    if (obj == null) {
      synchronized (SingletonThreadSafeOpt.class) {
        if (obj == null)
          obj = new SingletonThreadSafeOpt();
      }
    }
    return obj;
  }
}

public class SingletonThreadSafeImpl {
  public static void main(String[] args) {
    SingletonThreadSafe o1 = SingletonThreadSafe.getInstance();
    SingletonThreadSafe o2 = SingletonThreadSafe.getInstance();
    System.out.println(o1 == o2);

    SingletonThreadSafeOpt s1 = SingletonThreadSafeOpt.getInstance();
    SingletonThreadSafeOpt s2 = SingletonThreadSafeOpt.getInstance();
    System.out.println(s1 == s2);
  }
}
