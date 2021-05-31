package com.company.leftview;

import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }
}

public class LeftViewTree {

  public static void leftView1(Node root) {

    if (root == null)
      return;

    Queue<Node> q = new LinkedList<>();
    boolean first = true;
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      Node node = q.poll();
      if (node!=null) {
        if (first) {
          System.out.print(node.data + " ");
          first = false;
        }

        if (node.left!=null)
          q.add(node.left);
        if (node.right!=null)
          q.add(node.right);
      } else {
        if (!q.isEmpty()) {
          q.add(null);
        }
        first = true;
      }
    }
  }

  static int maxLevel = 0;

  public static void leftView2(Node root) {
    leftViewUtil(root, 1);
  }

  private static void leftViewUtil(Node root, int level) {
    if (root == null)
      return;
    if (maxLevel < level) {
      System.out.print(root.data + " ");
      maxLevel = level;
    }
    leftViewUtil(root.left, level + 1);
    leftViewUtil(root.right, level + 1);
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.right.right = new Node(6);
    System.out.println("Queue : ");
    leftView1(node);
    System.out.println();
    System.out.println("Recursion : ");
    leftView2(node);
    System.out.println();

    Node root = new Node(4);
    root.left = new Node(5);
    root.right = new Node(2);
    root.right.left = new Node(3);
    root.right.left.left = new Node(6);
    root.right.left.right = new Node(7);
    root.right.right = new Node(1);
    System.out.println("Queue : ");
    leftView1(root);
    System.out.println();
    maxLevel = 0;
    System.out.println("Recursion : ");
    leftView2(root);
  }
}
