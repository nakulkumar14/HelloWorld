package com.company.binarytree;

class Height {
  int h;
}

public class DiameterOfTree {

//  O(n^2)
  static int diameter(Node root) {
    if (root == null)
      return 0;

    int lh = HeightOfTree.height(root.left);
    int rh = HeightOfTree.height(root.right);

    int ld = diameter(root.left);
    int rd = diameter(root.right);

    return Math.max(Math.max(ld, rd), 1 + lh + rh );
  }

  static int diameterOpt(Node root) {
    Height height = new Height();
    return diameterOptUtil(root, height);
  }

  private static int diameterOptUtil(Node root, Height height) {
    if (root == null) {
      height.h = 0;
      return 0;
    }
    Height lh = new Height();
    Height rh = new Height();

//    Arrays.binarySearch(new int[]{1,2},2);

    int ld = diameterOptUtil(root.left,lh);
    int rd = diameterOptUtil(root.right,rh);

    height.h = Math.max(lh.h, rh.h) + 1;

    return Math.max(Math.max(ld, rd), 1 + lh.h + rh.h);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.right = new Node(3);
    System.out.println("Diameter : " + diameter(root));
    System.out.println("Diameter : " + diameterOpt(root));
  }
}
