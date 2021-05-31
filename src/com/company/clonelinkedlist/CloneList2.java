package com.company.clonelinkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneList2 {

    Node cloneLinkedList(Node head) {
        Node temp = head;
        Node copy = null;
        Node newHead = null;

        // create nodes with next node only
        while(temp!=null) {
            if (newHead == null) {
                newHead = new Node(temp.data);
                copy = newHead;
            }else {
                copy.next = new Node(temp.data);
                copy = copy.next;
            }
            temp = temp.next;
        }

        // save curr and next nodes in map
        Map<Node, Node> map = new HashMap<>();
        temp = head;
        while (temp!=null) {
            map.put(temp, temp.next);
            temp = temp.next;
        }

        copy = newHead;
        temp = head;

        // update original list next references.
        while (copy!=null) {
            Node curr = temp;
            temp = temp.next;
            copy.random = curr;
            curr.next = copy;
            copy = copy.next;
        }

        copy = newHead;

        // clone list - fix random pointers
        while (copy!=null) {
            copy.random = copy.random.random.next;
            copy = copy.next;
        }

        //fix original one
        temp = head;
        while (temp!=null) {
            temp.next = map.get(temp);
            temp = temp.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        CloneList2 obj = new CloneList2();

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

        node1.show();

        clone.show();

//        node1.show();
    }
}
