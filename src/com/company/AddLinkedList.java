package com.company;

// Add linked list without modifying
// 1 -> 2 -> 3 plus
// 2 -> 5 -> 6
// 3 -> 7 -> 9
public class AddLinkedList {

  static int carry = 0;
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  void show(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  int size(Node head) {
    int count = 0;
    Node temp = head;
    while (temp!=null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  Node addUtil(Node list1, Node list2, Node head) {

    if (list1 == null && list2 == null) {
      return head;
    }
    if (list1 != null && list2 == null) {
      return addUtil(list1.next, list2, head);
    }
    if (list1 == null && list2 != null) {
      return addUtil(list1, list2.next, head);
    }

    if (list1 != null && list2 != null) {
      Node prev = addUtil(list1.next, list2.next, head);
      int total = list1.data + list2.data + carry;
      int sum = total % 10;
      carry = total/10;

      Node temp = new Node(sum);
      temp.next = prev;
      prev = temp;
      head = prev;
    }

    return head;
  }

  Node add(Node list1, Node list2) {
    Node head = null;

    int l1 = size(list1);
    int l2 = size(list2);

    if (l1 == l2) {
      head = addUtil(list1, list2, head);

//      if (carry!=0) {
//        Node temp = new Node(carry);
//        temp.next = head;
//        head = temp;
//      }

    } else {
      int diff = l1 - l2;
      if (l1 < l2) {
        diff = l2 - l1;
        Node t = list1;
        list1 = list2;
        list2 = list1;

      }
      Node temp = list1;
      while (diff--!=0) {
        temp = temp.next;
      }
      head = addUtil(temp, list2, head);
      while (list1!=temp) {

        int total = list1.data + carry;
        int sum = total % 10;
        carry = total/10;

        Node t = new Node(sum);
        t.next = head;
        head = t;

        list1 = list1.next;
      }
    }

    if (carry!=0) {
      Node temp = new Node(carry);
      temp.next = head;
      head = temp;
    }

    return head;
  }

  public static void main(String[] args) {
    AddLinkedList obj = new AddLinkedList();

    Node list1 = new Node(1);
    list1.next = new Node(2);
    list1.next.next = new Node(3);
    obj.show(list1);

    Node list2 = new Node(9);
    list2.next = new Node(5);
//    list2.next.next = new Node(9);
    obj.show(list2);

    Node node = obj.add(list1, list2);
    obj.show(node);

  }
}
