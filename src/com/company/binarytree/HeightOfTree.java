package com.company.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

//  recursive O(n)
  static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int lh = height(root.left);
    int rh = height(root.right);
    return Math.max(lh, rh) + 1;
  }

  static int heightIterative(Node root) {
    int h = 0;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node node = q.poll();
        if (node.left!=null)
          q.add(node.left);
        if (node.right!=null)
          q.add(node.right);
      }

      h++;
    }

    return h;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.right = new Node(3);
    System.out.println("Height : " + height(root));
    System.out.println("Height : " + heightIterative(root));
  }
}
