package com.company.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1
 * 2    3
 * 4  5  6  7
 */
class NNode {
  int data;
  NNode nextRight;
  NNode left, right;

  NNode(int data) {
    this.data = data;
    this.left = this.right = null;
    this.nextRight = null;
  }
}

public class NextRightNode {

  static void nextRightTraverse(NNode root) {
    NNode temp = root;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.nextRight;
    }
    System.out.println("None");
    if (root.left != null) {
      nextRightTraverse(root.left);
    } else if (root.right != null) {
      nextRightTraverse(root.right);
    }
  }

  static void connectNextRight(NNode root) {
    if (root == null)
      return;
    Queue<NNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      NNode node = q.poll();
      if (node != null) {
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
        node.nextRight = q.peek();
      } else {
        if (!q.isEmpty()) {
          q.add(null);
        }
      }
    }
  }

  static NNode getNextRight(NNode root) {
    NNode temp = root.nextRight;
    while (temp!=null) {
      if (temp.left!=null)
        return temp.left;
      if (temp.right!=null)
        return temp.right;
      temp = temp.nextRight;
    }
    return null;
  }

  static void connectRecur(NNode root) {
    if (root == null)
      return;
    if (root.nextRight!=null) {
      connectRecur(root.nextRight);
    }
    if (root.left!=null) {
      if (root.right!=null) {
        root.left.nextRight = root.right;
        root.right.nextRight = getNextRight(root);
      } else {
        root.left.nextRight = getNextRight(root);
      }

      connectRecur(root.left);

    } else if (root.right!=null) {
      root.right.nextRight = getNextRight(root);
      connectRecur(root.right);
    } else {
      connectRecur(root.nextRight);
    }
  }

  public static void main(String[] args) {
    NNode root = new NNode(1);
    root.left = new NNode(2);
    root.left.left = new NNode(4);
    root.left.right = new NNode(5);
    root.right = new NNode(3);
    root.right.left = new NNode(6);
    root.right.right = new NNode(7);
//    connectNextRight(root);
    connectRecur(root);
    nextRightTraverse(root);

    root = new NNode(1);
    root.left = new NNode(2);
    root.left.left = new NNode(4);
//    root.left.right = new NNode(5);
    root.right = new NNode(3);
//    root.right.left = new NNode(6);
    root.right.right = new NNode(7);
//    connectNextRight(root);
    connectRecur(root);
    nextRightTraverse(root);
  }
}
