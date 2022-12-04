package com.company.list;

public class ReverseList {

  static Node reverse(Node head) {
    if (head == null || head.next == null)
      return head;

    Node rest = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return rest;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    Node.show(head);
    head = reverse(head);
    Node.show(head);
  }
}
