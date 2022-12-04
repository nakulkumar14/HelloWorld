package com.company.binarytree;

public class InorderSuccessor {

  static Node successor(Node root, Node node) {
    if (node.right != null) {
      Node succ = node.right;
      while (succ.left != null)
        succ = succ.left;
      return succ;
    }

    Node succ = null;
    while (root != null) {
      if (node.data > root.data) {
        root = root.right;
      } else if (node.data < root.data) {
        succ = root;
        root = root.left;
      } else {
        break;
      }
    }

    return succ;
  }

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(2);
    root.right = new Node(7);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(8);
    Node.inorder(root);
    System.out.println();
    System.out.println(successor(root, root).data);
    System.out.println(successor(root, root.left).data);
    System.out.println(successor(root, root.right).data);
    System.out.println(successor(root, root.left.left).data);
    System.out.println(successor(root, root.left.right).data);
    System.out.println(successor(root, root.right.left).data);
    System.out.println(successor(root, root.right.right));
  }
}
