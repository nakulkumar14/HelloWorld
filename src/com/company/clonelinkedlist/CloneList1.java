package com.company.clonelinkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneList1 {

    Node cloneLinkedList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp!=null) {
            Node newNode = new Node(temp.data);
            map.put(temp,newNode);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {

        CloneList1 obj = new CloneList1();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node2;

        Node clone = obj.cloneLinkedList(node1);
        clone.show();
    }
}
