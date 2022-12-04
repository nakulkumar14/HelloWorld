package com.company.threads;

import java.util.ArrayList;
import java.util.List;

class Connection {
  Connection() {

  }
}

interface IConnectionPool {
  Connection getConnection();

  void release(Connection connection);
}

class ConnectionImpl implements IConnectionPool {

  private int poolsize;
  private List<Connection> connectionList;
  private volatile int index = 0;

  ConnectionImpl(int poolsize) {
    this.poolsize = poolsize;
    this.connectionList = new ArrayList<>();
    for (int i = 0; i < poolsize; i++) {
      connectionList.add(new Connection());
    }
    System.out.println("Connection pool initialized.");
  }

  @Override
  public synchronized Connection getConnection() {
    while (index == poolsize - 1) {
      try {
        System.out.println("Worker : " + Thread.currentThread().getName() + " is waiting to get connection.");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Connection connection = connectionList.get(index);
    index++;
    notifyAll();
    return connection;
  }

  @Override
  public synchronized void release(Connection connection) {
    while (index == 0) {
      try {
        System.out.println("Worker : " + Thread.currentThread().getName() + " is waiting to release connection.");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    index--;
    notifyAll();
  }
}

class Worker extends Thread {
  IConnectionPool connectionPool;

  Worker(IConnectionPool connectionPool, String name) {
    super(name);
    this.connectionPool = connectionPool;
  }

  public void run() {
    System.out.println("Worker : " + Thread.currentThread().getName());
    Connection connection = connectionPool.getConnection();
    System.out.println("Worker : " + Thread.currentThread().getName() + " acquired connection.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    connectionPool.release(connection);
    System.out.println("Worker : " + Thread.currentThread().getName() + " finished job.");
  }
}

public class CustomConnectionPool1 {
  public static void main(String[] args) {
    IConnectionPool connectionPool = new ConnectionImpl(2);
    for (int i = 0; i < 5; i++) {
      new Worker(connectionPool, String.valueOf(i)).start();
    }
  }
}
