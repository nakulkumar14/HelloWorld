package com.company.binarytree;

public class BinarySearchTree {

  static void inorder(Node root) {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }
  }

  static Node insert(int data, Node root) {
    if (root == null) {
      root = new Node(data);
    } else if (data < root.data) {
      root.left = insert(data, root.left);
    } else {
      root.right = insert(data, root.right);
    }
    return root;
  }

  static Node insertIterative(int data, Node root) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    Node temp = root;
    Node parent = null;
    while (temp != null) {
      parent = temp;
      if (data < temp.data) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    if (data < parent.data) {
      parent.left = new Node(data);
    } else {
      parent.right = new Node(data);
    }
    return root;
  }

  static boolean search(int data, Node root) {
    if (root == null) {
      return false;
    }
    if (root.data == data) {
      return true;
    } else if (data < root.data) {
      return search(data, root.left);
    } else {
      return search(data, root.right);
    }
  }

  static boolean searchIterative(int data, Node root) {
    Node temp = root;
    while (temp != null) {
      if (temp.data == data) {
        return true;
      }
      if (data < temp.data) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    return false;
  }

  static Node delete(int data, Node root) {
    if (root == null) {
      return root;
    }
    if (root.data == data) {
      // no children
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left != null && root.right != null) {
        // both children present
        Node temp = root.left;
        while (temp.right != null) {
          temp = temp.right;
        }
        root.data = temp.data;
        root.left = delete(temp.data, root.left);
      } else {
        // only one child present
        if (root.left != null) {
          root = root.left;
        } else {
          root = root.right;
        }
      }
    } else if (data < root.data) {
      root.left = delete(data, root.left);
    } else {
      root.right = delete(data, root.right);
    }
    return root;
  }

  public static void main(String[] args) {

    /*
            4
          2   6
         1 3 5 7
     */

    Node root = null;
//    root = insert(4, root);
//    root = insert(6, root);
//    root = insert(5, root);
//    root = insert(7, root);
//    root = insert(2, root);
//    root = insert(1, root);
//    root = insert(3, root);

    root = insertIterative(4, root);
    root = insertIterative(6, root);
    root = insertIterative(5, root);
    root = insertIterative(7, root);
    root = insertIterative(2, root);
    root = insertIterative(1, root);
    root = insertIterative(3, root);
    inorder(root);
    System.out.println();
    System.out.println("Found 4 : " + search(4, root) + ", " + searchIterative(4, root));
    System.out.println("Found 1 : " + search(1, root) + ", " + searchIterative(1, root));
    System.out.println("Found 0 : " + search(0, root) + ", " + searchIterative(0, root));
    System.out.println("Found 10 : " + search(10, root) + ", " + searchIterative(10, root));

    System.out.println("Delete operation...");
    root = delete(4, root);
    System.out.println("Found 4 : " + search(4, root) + ", " + searchIterative(4, root));
    inorder(root);
    System.out.println();
  }
}
