package com.company.list;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }

  static void show(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("None");
  }
}

public class ReverseLinkedList {

  static int size(Node head) {
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  static Node reverse(Node head, int k) {
    if (head == null || k <= 0)
      return head;

    int size = size(head);
    if (size < k) {
      k = k - size;
    }

    int count = 0;
    Node temp = head;
    Node prev = null;
    while (count < k && temp != null) {
      count++;
      prev = temp;
      temp = temp.next;
    }
    prev.next = null;
    head = reverseUtil(head);
    Node t1 = head;
    while (t1.next != null)
      t1 = t1.next;

    t1.next = reverse(temp, k);

    return head;
  }

  private static Node reverseUtil(Node head) {
    if (head == null)
      return head;

    Node a = head, b, c = null;
    while (a != null) {
      b = a;
      a = a.next;
      b.next = c;
      c = b;
    }
    return c;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    Node.show(head);
//    Node node = reverse(head, 2);
//    Node node = reverse(head, 3);
//    Node node = reverse(head, 4);
    Node node = reverse(head, 7);
    Node.show(node);

    // 1 2 3 4 5
    // h
    //   t
  }
}
