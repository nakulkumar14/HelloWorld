package com.company.binarytree;

public class BinaryTreeToDLL {

  Node tail = null;

  void convert(Node root) {
    if (root != null) {
      convert(root.left);
      root.left = tail;
      if (tail != null) {
        tail.right = root;
        tail = tail.right;
      } else {
        tail = root;
      }
      convert(root.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(12);
    root.right = new Node(15);
    root.left.left = new Node(25);
    root.left.right = new Node(30);
    root.right.left = new Node(36);

    // Convert to DLL
//    Node head = bintree2list(root);
//
//    // Print the converted list
//    printList(head);

    BinaryTreeToDLL dll = new BinaryTreeToDLL();
    dll.convert(root);
    while (dll.tail.left != null)
      dll.tail = dll.tail.left;

    printList(dll.tail);
  }

  private static Node bintree2list(Node root) {
    if (root == null) return root;
    root = bintree2listUtil(root);
    while (root.left != null)
      root = root.left;
    return root;
  }

  private static Node bintree2listUtil(Node node) {
    if (node == null)
      return node;
    if (node.left != null) {
      Node left = bintree2listUtil(node.left);
      while (left.right != null)
        left = left.right;
      left.right = node;
      node.left = left;
    }
    if (node.right != null) {
      Node right = bintree2listUtil(node.right);
      while (right.left != null)
        right = right.left;
      right.left = node;
      node.right = right;
    }
    return node;
  }

  private static void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.right;
    }
    System.out.println("null");
  }
}