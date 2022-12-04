package com.company.binarytree;

public class MaxPathSumInBinaryTree {

  static int maxsum = 0;

  static void maxPathSum(Node root) {
    int[] path = new int[100];
    maxPathSum(root, path, 0);
    System.out.println("Max sum : " + maxsum);
  }

  private static void maxPathSum(Node root, int[] path, int i) {
    if (root == null) {
      return;
    }
    path[i] = root.data;
    if (root.left == null && root.right == null) {
      int sum = 0;
      for (int j=0;j<=i;j++) {
        sum += path[j];
      }
      maxsum = Math.max(maxsum, sum);
      return;
    }
    maxPathSum(root.left, path, i + 1);
    maxPathSum(root.right, path, i + 1);

  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(8);
    root.left.right = new Node(4);
    root.right.left = new Node(5);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(9);
    root.right.right = new Node(6);
    root.right.right.right = new Node(5);
//    Node.inorder(root);
    System.out.println();
    maxPathSum(root);
  }
}
