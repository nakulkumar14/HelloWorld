package com.company.clonelinkedlist;

public class Node {
    int data;
    Node next;
    Node random;

    public Node(int data) {
        this.data = data;
    }

    void show() {
        Node temp = this;
        while (temp!=null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();

        temp = this;
        while (temp!=null) {
            System.out.print(temp.random.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}
