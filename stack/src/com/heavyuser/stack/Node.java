package com.heavyuser.stack;
public class Node {
    private int value;
    private Node next;
    

    public Node() {
        this.next = null;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return this.next;
    }

    public void setNextNode(Node node) {
        this.next = node;
    } 

    public Node getNode() {
        return this.next;
    }

}
