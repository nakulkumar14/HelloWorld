package com.company;

public class CyclicQueue {

  private int[] arr;
  private int front, rear;
  private int currSize;

  public CyclicQueue(int size) {
    arr = new int[size];
    front = rear = 0;
    currSize = 0;
  }

  public void enqueue(int data) {
    if (currSize == arr.length) {
      System.out.println("Overflow");
      return;
    }
    arr[rear] = data;
    rear = (rear + 1) % arr.length;
    currSize++;
  }

  public int dequeue() {
    if (front == rear) {
      System.out.println("No element present");
      return -1;
    }
    int ele = arr[front];
    front = (front + 1) % arr.length;

    if (front == rear) {
      front = rear = 0;
    }
    currSize--;

    return ele;
  }

  public int getFront() {
    return arr[front];
  }

  public int getRear() {
    return arr[rear];
  }

  public void show() {

    if (currSize == 0) {
      System.out.println("Empty Queue");
      return;
    }

    if (rear <= front) {
      for (int i = front; i < arr.length; i++) {
        System.out.print(arr[i] + "->");
      }

      for (int i = 0; i < rear; i++) {
        System.out.print(arr[i] + "->");
      }

    } else {
      for (int i = front; i < rear; i++) {
        System.out.print(arr[i] + "->");
      }
    }
    System.out.println("None");
  }

  public static void main(String[] args) {
    CyclicQueue cq = new CyclicQueue(5);
    cq.dequeue();
    cq.show();
    cq.enqueue(1);
    cq.enqueue(2);
    cq.enqueue(3);
    cq.show();
    cq.dequeue();
    cq.show();
    cq.enqueue(4);
    cq.enqueue(5);
    cq.enqueue(6);
    cq.show();
    cq.enqueue(7);
  }
}
