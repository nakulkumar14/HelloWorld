package com.company.list;

public class MedianLinkedList {

  static int median(Node head) {
    Node slow = head, fast = head;
    Node prev = null;
    while (fast!=null && fast.next!=null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return (slow.data + prev.data)/2;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(4);
    head.next.next.next = new Node(6);
    head.next.next.next.next = new Node(8);
    head.next.next.next.next.next = new Node(9);
    Node.show(head);
    System.out.println(median(head));
  }
}
