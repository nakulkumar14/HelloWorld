package com.test;

public class ReverseRecursively {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  static void show(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");

  }

  static Node reverse(Node head) {
    if (head == null) {
      return head;
    }

    Node first = head;
    Node rest = first.next;

    if (rest == null) {
      return first;
    }

    Node newHead = reverse(rest);

    first.next.next = first;
    first.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    node.next.next.next.next = new Node(5);

    show(node);
    node = reverse(node);
    show(node);

  }
}
