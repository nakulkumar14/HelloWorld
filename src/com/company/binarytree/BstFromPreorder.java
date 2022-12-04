package com.company.binarytree;

import java.util.Stack;

public class BstFromPreorder {

  Node bstFromPreorder(int arr[]) {
    Stack<Node> stack = new Stack<>();
    Node root = new Node(arr[0]);
    stack.push(root);

    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i]);

      if (stack.peek().data > temp.data) {
        stack.peek().left = temp;
      } else {
        Node p = stack.peek();
        while (!stack.isEmpty() && stack.peek().data < temp.data) {
          p = stack.pop();
        }
        p.right = temp;
      }

      stack.push(temp);
    }

    return root;
  }

  public static void main(String[] args) {
    BstFromPreorder o = new BstFromPreorder();
    int arr[] = {10, 5, 1, 7, 40, 50};
    Node root = o.bstFromPreorder(arr);
    Node.inorder(root);
  }
}
