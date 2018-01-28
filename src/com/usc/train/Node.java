package com.usc.train;

/**
 * Created by xuqiang on 2017/11/26.
 */
public class Node {
    private int Data;
    private Node Next;

    public Node(int data) {
        Data = data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
