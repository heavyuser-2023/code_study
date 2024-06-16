package com.heavyuser.stack;
public class Stack {
    Node topNode;
    public Stack () {
        topNode = new Node();
    }

    public void push(int value) {
        topNode = new Node(value, topNode);
    }

    public int pop() {
        if(topNode.getNextNode() == null) {
            return -1;
        }
        int popValue = topNode.getValue();
        topNode = topNode.getNextNode();
        return popValue;
    }


    public int size() {
        int size = 0;
        Node currentNode = topNode;
        while (currentNode.getNextNode() != null) {
            size++;
            currentNode = currentNode.getNextNode();    
        }
        return size;
    }
    
    public int empty() {
        if(topNode.getNextNode() == null) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    public int top () {
        if(topNode.getNextNode() == null) {
            return -1;
        }
        return topNode.getValue();
    }

}
