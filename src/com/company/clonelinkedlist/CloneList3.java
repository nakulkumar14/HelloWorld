package com.company.clonelinkedlist;

public class CloneList3 {
    private Node cloneLinkedList(Node head) {
        Node temp = head;
        while(temp!=null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }

        System.out.println("nodes inserted");

        temp = head;
        Node copy = temp.next;

        while (temp!=null) {
            copy.random = temp.random.next;
            temp = temp.next.next;
            copy = copy.next!=null ? copy.next.next : null;
        }

        System.out.println("random fixed");

        temp = head;
        copy = temp.next;
        Node newHead = copy;
        while (temp!=null && copy!=null) {
            temp.next = temp.next!=null? temp.next.next : null;
            copy.next = copy.next!=null? copy.next.next : null;

            temp = temp.next;
            copy = copy.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        CloneList3 obj = new CloneList3();

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
