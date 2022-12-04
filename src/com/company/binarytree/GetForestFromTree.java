package com.company.binarytree;

import java.util.ArrayList;
import java.util.List;

public class GetForestFromTree {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    Node.inorder(root);
    System.out.println();
    List<Node> forest = getForest(root, List.of(1, 3));
    System.out.println("Forest size : " + forest.size());
    for (Node tree : forest) {
      Node.inorder(tree);
      System.out.println();
    }
  }

  static List<Node> getForest(Node root, List<Integer> toBeDeleted) {
    List<Node> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Node node = getForestUtil(root, result, toBeDeleted);
    if (node!=null && !toBeDeleted.contains(node)) {
      result.add(node);
    }
    return result;
  }

  private static Node getForestUtil(Node root, List<Node> result, List<Integer> toBeDeleted) {
    if (root == null)
      return null;

    root.left = getForestUtil(root.left, result, toBeDeleted);
    root.right = getForestUtil(root.right, result, toBeDeleted);
    if (toBeDeleted.contains(root.data)) {

      if (root.left != null) {
        result.add(root.left);
      }
      if (root.right != null) {
        result.add(root.right);
      }
      root = null;
    }
    return root;
  }
}
