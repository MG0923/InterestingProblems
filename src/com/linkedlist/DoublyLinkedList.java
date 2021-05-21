package com.linkedlist;

public class DoublyLinkedList {
    private static Node head;

    static class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private static void push(int val) {
        if(head == null){
            head = new Node(val, null, null);;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = new Node(val, null, curr);
    }

    private static void addANodeAfterGivenKey(int key, int value){
        Node curr  = head;
        while(curr !=null && curr.val != key){
            curr = curr.next;
        }

        Node tempCur = curr.next;
        Node tempPrev = curr;

        curr.next = new Node(value, tempCur, tempPrev);
        tempCur.prev = curr.next;
    }

    static void printList(){
        if(head == null){
            System.out.println("INVALID");
            return;
        }
        Node cur = head;
        while(cur != null){
            int val = cur.prev == null?0:cur.prev.val;
            System.out.print(val+"::"+cur.val +"->");
            cur= cur.next;
        }
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        printList();
        addANodeAfterGivenKey(40, 45);
        System.out.println();
        printList();
    }
}
