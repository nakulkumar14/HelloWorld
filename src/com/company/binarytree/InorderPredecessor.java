package com.company.binarytree;

public class InorderPredecessor {

  static Node search(Node root, int data) {
    Node temp = root;
    while (temp != null) {
      if (temp.data == data)
        return temp;
      if (data < temp.data)
        temp = temp.left;
      else
        temp = temp.right;
    }
    return null;
  }

  static Node predecessor(Node root, int data) {
    Node search = search(root, data);
    Node pre = search.left;
    if (pre != null) {
      while (pre.right != null)
        pre = pre.right;
      return pre;
    }

    pre = null;
    while (root != null) {
      if (data > root.data) {
        pre = root;
        root = root.right;
      } else if (data < root.data) {
        root = root.left;
      } else {
        break;
      }
    }
    return pre;
  }

  static Node pre = null;

  static void predecessor2(Node root, Node node) {
    pre = null;
    predecessor2util(root, node);
    if (pre == null)
      pre = new Node(0);
  }

  static void predecessor2util(Node root, Node node) {
    if (root.left != null) {
      predecessor2util(root.left, node);
    }

    if (pre == null && root.data < node.data) {
      pre = root;
    } else if (pre != null && pre.data < root.data && root.data < node.data) {
      pre = root;
    }

    if (root.right != null) {
      predecessor2util(root.right, node);
    }
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
    System.out.println("2 : " + predecessor(root, 2).data);
    predecessor2(root, root.left);
    System.out.println(pre.data);

    System.out.println("3 : " + predecessor(root, 3).data);
    predecessor2(root, root.left.right);
    System.out.println(pre.data);

    System.out.println("1 : " + predecessor(root, 1));
    predecessor2(root, root.left.left);
    System.out.println(pre.data);

    System.out.println(predecessor(root, 5).data);
    predecessor2(root, root);
    System.out.println(pre.data);
//    System.out.println(predecessor(root, 6).data);
//    System.out.println(predecessor(root, 7).data);
//    System.out.println(predecessor(root, 8).data);
  }
}
