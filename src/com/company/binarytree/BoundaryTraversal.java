package com.company.binarytree;

public class BoundaryTraversal {

  void leftTraversal(Node node) {
    if (node != null) {
      if (node.left != null) {
        System.out.print(node.data + " ");
        leftTraversal(node.left);
      } else if (node.right != null) {
        System.out.print(node.data + " ");
        leftTraversal(node.right);
      }
    }
  }

  void rightTraversal(Node node) {
    if (node != null) {
      if (node.right != null) {
        rightTraversal(node.right);
        System.out.print(node.data + " ");
      } else if (node.left != null) {
        rightTraversal(node.left);
        System.out.print(node.data + " ");
      }
    }
  }

  void printLeaves(Node node) {
    if (node != null) {
      printLeaves(node.left);
      if (node.left == null && node.right == null) {
        System.out.print(node.data + " ");
      }
      printLeaves(node.right);
    }
  }

  void boundaryTraversal(Node node) {
    leftTraversal(node);
    printLeaves(node);
    rightTraversal(node.right);
  }

  public static void main(String[] args) {
    /*
             1
       2          3
    4    5     6     7
   8 9 10 11 12 13 14 15

     */
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(11);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.left.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right = new Node(7);
    root.right.right.left = new Node(14);
    root.right.right.right = new Node(15);

    BoundaryTraversal o = new BoundaryTraversal();
    o.boundaryTraversal(root);

  }
}
