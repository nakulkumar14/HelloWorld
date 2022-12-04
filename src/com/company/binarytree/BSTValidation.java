package com.company.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BSTValidation {

  static boolean isBst1(Node root) {
    if (root == null) {
      return true;
    }
    List<Integer> list = new ArrayList<>();
    isBSt1util(root, list);
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) > list.get(i + 1))
        return false;
    }
    return true;
  }

  private static void isBSt1util(Node root, List<Integer> list) {
    if (root != null) {
      isBSt1util(root.left, list);
      list.add(root.data);
      isBSt1util(root.right, list);
    }
  }

  static boolean isBst2(Node root) {
    return isBst2util(root, null);
  }

  private static boolean isBst2util(Node root, Node prev) {
    if (root == null)
      return true;
    boolean isLeftBst = isBst2util(root.left, prev);
    if (!isLeftBst)
      return false;
    if (prev != null && prev.data > root.data)
      return false;
    prev = root;
    return isBst2util(root.right, prev);
  }

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(6);
    root.left.left = new Node(2);
    root.left.right = new Node(8);
    root.right = new Node(7);
    root.right.left = new Node(2);
    root.right.right = new Node(17);

    Node.inorder(root);
    System.out.println(isBst1(root));
    System.out.println(isBst2(root));

    root = new Node(5);
    root.left = new Node(2);
    root.right = new Node(7);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(8);
    Node.inorder(root);
    System.out.println(isBst1(root));
    System.out.println(isBst2(root));
  }
}
