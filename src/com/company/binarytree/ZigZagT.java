package com.company.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZigZagT {
  static void zigzagUsingDeque(Node root) {
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(root);
    boolean flag = false;
    while (deque.size() > 0) {
      int size = deque.size();
      if (flag) {
        for (int i = 0; i < size; i++) {
          Node node = deque.removeFirst();
          if (node.left!=null) {
            deque.addLast(node.left);
          }
          if (node.right!=null) {
            deque.addLast(node.right);
          }
          System.out.print(node.data + " ");
        }
        System.out.println();
      } else {
        for (int i = 0; i < size; i++) {
          Node node = deque.removeLast();
          if (node.right!=null) {
            deque.addFirst(node.right);
          }
          if (node.left!=null) {
            deque.addFirst(node.left);
          }
          System.out.print(node.data + " ");
        }
        System.out.println();
      }
      flag = !flag;
    }
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
//    Node.inorder(root);
    Node.levelOrder(root);
    System.out.println();
    zigzagUsingDeque(root);
  }
}
