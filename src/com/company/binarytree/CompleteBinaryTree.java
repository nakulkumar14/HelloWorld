package com.company.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree {

  static boolean isComplete(Node root) {
    if (root == null)
      return true;

    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    boolean flag = false;
    while (q.size() > 0) {
      Node temp = q.poll();
      if (temp.left != null) {
        if (flag)
          return false;

        q.add(temp.left);

      } else {
        flag = true;
      }

      if (temp.right != null) {
        if (flag)
          return false;

        q.add(temp.right);
      } else {
        flag = true;
      }
    }
    return true;
  }

  static boolean isComplete2(Node root) {
    if (root == null)
      return true;
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    Node marker = new Node(-1);
    boolean flag = false;
    while (q.size() > 0) {
      Node temp = q.poll();
//      System.out.println(temp.data);
      if (temp == marker) {
        flag = true;
      } else {
        if (flag)
          return false;
        q.add(temp.left!=null? temp.left : marker);
        q.add(temp.right!=null? temp.right : marker);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.right.left = new Node(6);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    System.out.println(isComplete(node));
    System.out.println(isComplete2(node));

  }
}
