package com.company.binarytree;

//https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
public class Pathsum {

  static boolean isPathSum(Node root, int sum) {
    if (root == null && sum == 0) {
      return true;
    }
    if (root == null || sum == 0) {
      return false;
    }
    if (sum < 0)
      return false;

    sum = sum - root.data;
    return isPathSum(root.left, sum) || isPathSum(root.right, sum);
  }

  public static void main(String[] args) {
    Node node = new Node(10);
    node.left = new Node(8);
    node.left.left = new Node(3);
    node.left.right = new Node(5);
    node.right = new Node(2);
    node.right.left = new Node(2);
//    Node.inorder(node);
    System.out.println(isPathSum(node, 21));
    System.out.println(isPathSum(node, 23));
    System.out.println(isPathSum(node, 14));
    System.out.println(isPathSum(node, 10));
  }
}
