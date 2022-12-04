package com.company.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/convert-bst-to-max-heap/
public class ConvertBSTToHeap {

  static int i = 0;

  void inorder(Node root, List<Integer> list){
    if (root!=null) {
      inorder(root.left, list);
      list.add(root.data);
      inorder(root.right, list);
    }
  }

  void convert(Node root) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    convertUtil(root, list);
  }

  private void convertUtil(Node root, List<Integer> list) {
    if (root!=null) {
      convertUtil(root.left, list);
      convertUtil(root.right, list);
      root.data = list.get(i++);
    }
  }

  public static void main(String[] args) {
    ConvertBSTToHeap o = new ConvertBSTToHeap();
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);

    Node.inorder(root);
    System.out.println();
    o.convert(root);
    Node.postorder(root);

  }
}
