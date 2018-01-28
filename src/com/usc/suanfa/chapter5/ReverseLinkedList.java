package com.usc.suanfa.chapter5;

/**
 * Created by xuqiang on 2017/12/10.
 *
 * 单链表的反转
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    static class Node{
        int data;
        Node next;
    }

    /**
     * 返回链表的头结点
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        Node pre = null;
        Node cur = head;
        while (cur !=null){
            Node next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void removeElements(Node head,int val){
        Node cur = head;
        while(cur.next!=null){
            if(cur.next.data ==val){
                Node delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else {
                cur = cur.next;
            }
        }
    }

    /**
     * 链表中交换成对元素的位置
     * @param head
     */
    public static void swapPair(Node head){
        Node dummyHead = new Node();
        dummyHead.data =0;
        dummyHead.next = head;

        Node p = dummyHead;

        while(p.next!=null && p.next.next!=null){
            Node node1 = p.next;
            Node node2 = node1.next;
            Node next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
    }
}
