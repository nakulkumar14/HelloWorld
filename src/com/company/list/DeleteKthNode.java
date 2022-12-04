package com.company.list;

public class DeleteKthNode {

  static Node deleteKthNode(Node head, int k) {
    if (head == null) {
      return head;
    }

    if (k == 1) {
      return null;
    }

    int count = 0;
    Node temp = head;
    Node prev = head;
    while (temp != null && count != k - 1) {
      prev = temp;
      temp = temp.next;
      count++;
    }

    if (temp != null)
      prev.next = deleteKthNode(temp.next, k);
    else
      prev.next = null;
    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.next = new Node(7);
    head.next.next.next.next.next.next.next = new Node(8);
    Node.show(head);
//    Node.show(deleteKthNode(head, 3));
//    Node.show(deleteKthNode(head, 4));
//    Node.show(deleteKthNode(head, 2));
    Node.show(deleteKthNode(head, 1));
  }
}
