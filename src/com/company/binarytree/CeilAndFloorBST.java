package com.company.binarytree;

public class CeilAndFloorBST {

  static Node floor, ceil;

  static void ceilAndFloor(Node root, int key) {

    if (root == null)
      return;

    if (root.data == key) {
      floor = root;
      ceil = root;
    } else if (key < root.data) {
//      if (ceil == null) {
//        ceil = root;
//      } else if (ceil.data > root.data) {
//        ceil = root;
//      }
      ceil = root;
      ceilAndFloor(root.left, key);
    } else if (key > root.data) {
      floor = root;
      ceilAndFloor(root.right, key);
    }

//    if (root.left != null)
//      ceilAndFloor(root.left, key);

//    if (root.right != null)
//      ceilAndFloor(root.right, key);
  }

  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(4);
    root.right = new Node(10);
    root.left.left = new Node(2);
    root.left.right = new Node(6);
    root.right.left = new Node(9);
    root.right.right = new Node(12);
    Node.inorder(root);
    System.out.println();

    ceilAndFloor(root, 1);
    System.out.println("floor of 1 is " + (floor != null ? floor.data : 0) + ", ceil of 1 is " + ceil.data);

    ceilAndFloor(root, 3);
    System.out.println("floor of 3 is " + floor.data + ", ceil of 3 is " + ceil.data);

    ceilAndFloor(root, 9);
    System.out.println("floor of 9 is " + floor.data + ", ceil of 9 is " + ceil.data);

    ceilAndFloor(root, 7);
    System.out.println("floor of 7 is " + floor.data + ", ceil of 7 is " + ceil.data);
  }
}
