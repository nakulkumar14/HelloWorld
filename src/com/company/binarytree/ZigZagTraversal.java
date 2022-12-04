package com.company.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTraversal {

  static void zigzagUsingDeque(Node root) {
    System.out.println("zigzagUsingDeque");
    if (root == null) return;
    Deque<Node> dq = new LinkedList<>();
    boolean flag = true;
    dq.add(root);
    while (!dq.isEmpty()) {
      int size = dq.size();
      for (int i = 0; i < size; i++) {
        if (!flag) {
          Node node = dq.removeLast();
          if (node.left != null) {
            dq.addFirst(node.left);
          }
          if (node.right != null) {
            dq.addFirst(node.right);
          }
          System.out.print(node.data + " ");
        } else {
          Node node = dq.removeFirst();
          if (node.right != null) {
            dq.addLast(node.right);
          }
          if (node.left != null) {
            dq.addLast(node.left);
          }
          System.out.print(node.data + " ");
        }
      }
      flag = !flag;
    }
    System.out.println();
  }

  static void zigzagUsingStacks(Node root) {
    System.out.println("zigzagUsingStacks");
    if (root == null) return;
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();

    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        Node node = s1.pop();
        if (node.right != null) {
          s2.push(node.right);
        }
        if (node.left != null) {
          s2.push(node.left);
        }

        System.out.print(node.data + " ");
      }

      while (!s2.isEmpty()) {
        Node node = s2.pop();
        if (node.left != null) {
          s1.push(node.left);
        }
        if (node.right != null) {
          s1.push(node.right);
        }
        System.out.print(node.data + " ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right = new Node(5);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(11);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.left.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right = new Node(7);
    root.right.right.left = new Node(14);
    root.right.right.right = new Node(15);
    Node.inorder(root);
    System.out.println();
    zigzagUsingStacks(root);
    zigzagUsingDeque(root);
  }
}
