package com.company.binarytree;

public class WidthOfTree {

  static int min = 0;
  static int max = 0;

  static void width(Node root, int hd) {
    if (root == null)
      return;

    if (min > hd)
      min = hd;

    if (max < hd)
      max = hd;

    width(root.left, hd - 1);
    width(root.right, hd + 1);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(1);
    root.right = new Node(1);

    root.left.left = new Node(1);
    root.left.right = new Node(1);
    root.right.left = new Node(1);
    root.right.right = new Node(1);
    root.right.left.left = new Node(1);
    root.right.left.right = new Node(1);
    root.right.right.left = new Node(1);
    root.right.right.right = new Node(1);

    width(root, 0);
    System.out.println(Math.abs(min) + max);
  }
}
