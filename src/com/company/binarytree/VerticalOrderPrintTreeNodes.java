package com.company.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderPrintTreeNodes {

  static ArrayList<Integer> verticalOrder(Node root)
  {
    // add your code here
    ArrayList<Integer> result = new ArrayList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    cal(map, root, 0);

    map.forEach((k,v)->{
      if(v!=null)
        result.addAll(v);
    });

    return result;
  }

  static void cal(Map<Integer, List<Integer>> map, Node root, int hd) {
    if(root == null)
      return;

    if(map.get(hd)==null){
      map.put(hd, new ArrayList<>());
    }
    map.get(hd).add(root.data);

    cal(map, root.left, hd - 1);
    cal(map, root.right, hd + 1);

  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.left.right = new Node(8);

    root.right.right = new Node(7);
    root.right.right.right = new Node(9);

    ArrayList<Integer> list = verticalOrder(root);
    System.out.println(list);
  }
}
