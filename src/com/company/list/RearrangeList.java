package com.company.list;

public class RearrangeList {

  static Node middle(Node head) {
    Node slow = head;
    Node fast = head;
    Node prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast == null) {
      prev.next = null;
      return slow;
    }

    if (fast.next == null) {
      prev.next = null;
      return slow;
    }

    return null;
  }

  static Node reverse(Node head) {
    Node a = head;
    Node b, c = null;
    while (a != null) {
      b = a;
      a = a.next;
      b.next = c;
      c = b;
    }
    return c;
  }

  static Node rearrange(Node head) {
    // middle element
    Node mid = middle(head);

    // reverse
    Node rev = reverse(mid);

    Node curr = new Node(0);
    Node newHead = curr;
    while (head != null || rev != null) {
      if (head != null) {
        curr.next = head;
        curr = curr.next;
        head = head.next;
      }
      if (rev != null) {
        curr.next = rev;
        curr = curr.next;
        rev = rev.next;
      }

    }

    return newHead.next;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
//    head.next.next.next.next.next = new Node(6);
    Node.show(head);
    Node.show(rearrange(head));
  }
}
