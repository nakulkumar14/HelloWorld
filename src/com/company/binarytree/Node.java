package com.company.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }

  public static void inorder(Node root) {
    if (root!=null) {
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }
  }

  public static void postorder(Node root) {
    if (root!=null) {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
    }
  }

  public static void levelOrder(Node root) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        if (node.left!=null) {
          queue.add(node.left);
        }
        if (node.right!=null) {
          queue.add(node.right);
        }
        System.out.print(node.data + " ");
      }
      System.out.println();
    }
  }
}